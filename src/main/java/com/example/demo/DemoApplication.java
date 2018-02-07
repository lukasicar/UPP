package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Category;
import com.example.demo.model.MockUser;
import com.example.demo.model.TenderRequest;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	

	private static Scanner scanner;
	
	@Autowired
	private UserRepository userRepository;
	
	@Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
            	DemoApplication.scanner = new Scanner(System.in);
                Map<String, Object> variables = new HashMap();
                
                
                /*
                System.out.println("Ukupan broj deployment-a: " + repositoryService.createDeploymentQuery().count());
                ProcessDefinition pdf = (ProcessDefinition)repositoryService.createProcessDefinitionQuery().list().get(
                  repositoryService.createProcessDefinitionQuery().list().size() - 1);
                MockUser u = new MockUser();
                u.setUsername("zzgembo");
                u.setAddress("Novi Grad");
                u.setType(User.Type.firm);
                u.setMail("milos@localhost");
                
                variables.put("user", u);
                
                ProcessInstance pi=runtimeService.startProcessInstanceById(pdf.getId(), variables);
                System.out.println(pdf.getId());
                System.out.println(pi.getId());
                variables.put("pi", pi.getId());
                //runtimeService.startProcessInstanceByKey("hireProcess",variables);
                List<Task> tasks = taskService.createTaskQuery().active().list();
                System.out.println(tasks);
                Task t=tasks.get(0);
                taskService.complete(t.getId(),variables);
                
                System.out.println("kraj");
                for (Deployment d : repositoryService.createDeploymentQuery().list()) {
                  repositoryService.deleteDeployment(d.getId(), true);
                }*/
                
                
                System.out.println("Ukupan broj deployment-a: " + repositoryService.createDeploymentQuery().count());
                ProcessDefinition pdf = (ProcessDefinition)repositoryService.createProcessDefinitionQuery().list().get(
                  repositoryService.createProcessDefinitionQuery().list().size() - 1);
                
                TenderRequest tr=new TenderRequest();
                Category c=new Category();
                c.setName("Fasada");
                tr.setCategory(c);
                tr.setMaksimalniBrojPonuda(5);
                tr.setOpisPosla("trlababalan");
                tr.setProcjenaVrijednosti(20);
                tr.setRokZaPrimanjePonuda(new Date(1994, 8,3));
                tr.setRokZaIzvrsavanjeUsluge(new Date());
                variables.put("tr", tr);
                User u=userRepository.findByUsername("user1");
                variables.put("user", u);
                runtimeService.startProcessInstanceById(pdf.getId(), variables);
                List<Task> tasks=taskService.createTaskQuery().active().list();
                System.out.println(tasks);
                System.out.println(tasks.get(0).getAssignee());
                taskService.complete(tasks.get(0).getId());
                for (Deployment d : repositoryService.createDeploymentQuery().list()) {
                    repositoryService.deleteDeployment(d.getId(), true);
                }
            }
        };

    }

}
