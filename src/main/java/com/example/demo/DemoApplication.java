package com.example.demo;

import java.util.ArrayList;
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
import com.example.demo.model.FirmOffer;
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
                c.setName("Nabaca");
                tr.setCategory(c);
                tr.setMaksimalniBrojPonuda(5);
                tr.setOpisPosla("trlababalan");
                tr.setProcjenaVrijednosti(20);
                tr.setRokZaPrimanjePonuda(new Date(1994, 8,3));
                tr.setRokZaIzvrsavanjeUsluge(new Date());
                variables.put("tr", tr);
                User u=userRepository.findByUsername("user1");
                variables.put("user", u);
                List<FirmOffer> firmOffers=new ArrayList<>();
                variables.put("firmOffers", firmOffers);
                ProcessInstance pi=runtimeService.startProcessInstanceById(pdf.getId(), variables);
                List<Task> tasks=taskService.createTaskQuery().active().list();
                System.out.println(tasks);
                //System.out.println(tasks.get(0).getAssignee());
                taskService.complete(tasks.get(tasks.size()-1).getId());
                //System.out.println(taskService.createTaskQuery().active().list());
                Task t=taskService.createTaskQuery().active().list().get(taskService.createTaskQuery().active().list().size()-1);
                //t.getProcessVariables().put("odabir1", false);
                //System.out.println(t.getProcessVariables());
                //System.out.println(runtimeService.getVariables(pi.getId()));
                Map<String,Object> v1=runtimeService.getVariables(t.getProcessInstanceId());
                v1.put("odabir1", true);
                //System.out.println(v1);
                //System.out.println(runtimeService.getVariables(t.getProcessInstanceId()));
                try{taskService.complete(t.getId(),v1);}catch (Exception e) {
					// TODO: handle exception
                	System.out.println(e.getLocalizedMessage());
                	System.out.println("idemo dalje");
				}
                System.out.println(taskService.createTaskQuery().active().list());
                
                for (Deployment d : repositoryService.createDeploymentQuery().list()) {
                    repositoryService.deleteDeployment(d.getId(), true);
                }
            }
        };

    }

}
