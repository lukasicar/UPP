package com.example.demo.rest;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirmMail")
public class ConfirmationMail {

	@Autowired
	private RuntimeService runtimeService;
	
	@GetMapping("/get/{id}")
	public void lizarazu(@PathVariable String id) {
		Execution execution = runtimeService.createExecutionQuery().processInstanceId(id).signalEventSubscriptionName("alert").singleResult();
		runtimeService.signalEventReceived("alert", execution.getId());
		System.out.println("potvrdjen mail");
	}
	
	
}
