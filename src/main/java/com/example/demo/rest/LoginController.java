package com.example.demo.rest;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@GetMapping
	public String opsasa() {
		
		System.out.println(repositoryService.createDeploymentQuery().list());
		//runtimeService.startProcessInstanceByKey("hireProcess");
		//runtimeService.startProcessInstanceByKey("myProcess");
		for (Deployment d : repositoryService.createDeploymentQuery().list()) {
            repositoryService.deleteDeployment(d.getId(), true);
        }
		return "smailaga";
	}
	
	@GetMapping("/ocisti")
	public void eto() {
		for (Deployment d : repositoryService.createDeploymentQuery().list()) {
            repositoryService.deleteDeployment(d.getId(), true);
        }
	}
	
	
}
