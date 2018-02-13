package com.example.demo.rest;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MockTask;
import com.example.demo.model.TenderRequest;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins="http://localhost:4200")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/getTasks")
	public List<MockTask> getTasks(HttpServletRequest request){
		List<Task> lista=taskService.createTaskQuery().active().taskAssignee(request.getHeader("username")).list();
		return MockTask.convert(lista);
		//return taskService.createTaskQuery().taskAssignee("localhost").list();
	}
	
	@PostMapping("/tenderRequest/{id}")
	public String createTenderRequest(@RequestBody TenderRequest tr,@PathVariable String id) {
		Task t=taskService.createTaskQuery().taskId(id).singleResult();
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(t.getProcessInstanceId());
		variables.put("tr", tr);
		taskService.complete(id,variables);
		return "eto";
	}
	
	@GetMapping("/startProcess")
	public String startProcess(HttpServletRequest request) {
		User u=userRepository.findByUsername(request.getHeader("username"));
		HashMap<String, Object> variables=new HashMap<>();
		variables.put("user", u);
		runtimeService.startProcessInstanceByKey("myProcess",variables);
		return "startan process";
	}
	
	@PostMapping("/odabir1/{id}")
	public String odibar1(@RequestBody String choice,@PathVariable String id) {
		Task t=taskService.createTaskQuery().taskId(id).singleResult();
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(t.getProcessInstanceId());
		if(choice.equals("Da"))
			variables.put("odabir1",true);
		else
			variables.put("odabir1",false);
		taskService.complete(id,variables);
		return "cabar";
	}
	
}
