package com.example.demo.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MockTask;
import com.example.demo.model.MockUser;
import com.example.demo.repositories.CategoryRepository;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {

	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/startProcess")
	public String insalah(HttpServletRequest request) {
		HashMap<String, Object> variables=new HashMap<>();
		variables.put("korisnik", request.getServerName());
		runtimeService.startProcessInstanceByKey("hireProcess",variables);
		//System.out.println(repositoryService.createProcessDefinitionQuery().count());
		return "nije htjela";
	}
	
	
	@GetMapping("/getTasks")
	public List<MockTask> getTasks(HttpServletRequest request){
		List<Task> lista=taskService.createTaskQuery().active().taskAssignee(request.getServerName()).list();
		return MockTask.convert(lista);
		//return taskService.createTaskQuery().taskAssignee("localhost").list();
	}
	
	@PostMapping("/registracijaKorisnika/{id}")
	public String eiopsasa(@PathVariable String id,@RequestBody MockUser mu) {
		Task t=taskService.createTaskQuery().taskId(id).singleResult();
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(t.getProcessInstanceId());
		if(variables.containsKey("user")) {
			MockUser mm=(MockUser) variables.get("user");
			if(mu.getUsername()==null) {
				mm.setCategory(mu.getCategory());
				//mm.setCategory(categoryRepository.findOne(mu.getCategory().getName()));
				mm.setUdaljenost(mu.getUdaljenost());
				variables.put("user", mm);
				try {
					taskService.complete(id,variables);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				System.out.println("bila firma");
				return "adads";
			}
		}
		variables.put("user", mu);
		taskService.complete(id,variables);
		System.out.println("bio obican");
		return "adads";
	}
	
	
	
}
