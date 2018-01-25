package com.example.demo;

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
import org.activiti.engine.task.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.MockUser;
import com.example.demo.model.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	

	private static Scanner scanner;
	
	@Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
            	DemoApplication.scanner = new Scanner(System.in);
                Map<String, Object> variables = new HashMap();
                
                System.out.println("Ukupan broj deployment-a: " + repositoryService.createDeploymentQuery().count());
                ProcessDefinition pdf = (ProcessDefinition)repositoryService.createProcessDefinitionQuery().list().get(
                  repositoryService.createProcessDefinitionQuery().list().size() - 1);
                
                MockUser u = new MockUser();
                u.setUsername("zzgembo");
                u.setAddress("Novi Grad");
                u.setType(User.Type.firm);
                u.setMail("luka.sicar@uns.ac.rs");
                
                variables.put("user", u);
                
                runtimeService.startProcessInstanceById(pdf.getId(), variables);
                
                List<Task> tasks = taskService.createTaskQuery().active().list();
                System.out.println(tasks);
                Task t=tasks.get(0);
                taskService.complete(t.getId());
                
                System.out.println("kraj");
                for (Deployment d : repositoryService.createDeploymentQuery().list()) {
                  repositoryService.deleteDeployment(d.getId(), true);
                }
            }
        };

    }

}
