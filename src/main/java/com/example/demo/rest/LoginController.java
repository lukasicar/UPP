package com.example.demo.rest;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public String opsasa(HttpServletRequest request) {
		String username=(String) request.getHeader("username");
		String password=(String) request.getHeader("password");
		User u=userRepository.findByUsername(username);
		if(u==null) {
			return "korisnik";
		}else if(!u.getPassword().equals(password)) {
			return "password";
		}else {
			return "ok";
		}
	}
	
	@GetMapping("/ocisti")
	public void eto() {
		for (Deployment d : repositoryService.createDeploymentQuery().list()) {
            repositoryService.deleteDeployment(d.getId(), true);
        }
	}
	
	
}
