package com.example.demo.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
import com.example.demo.model.TenderResponse;
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
		
		//vrijeme nije dobro
		Calendar c = Calendar.getInstance(); 
		c.setTime(tr.getRokZaPrimanjePonuda()); 
		c.add(Calendar.HOUR, -1);
		tr.setRokZaPrimanjePonuda(c.getTime());
		
		c.setTime(tr.getRokZaIzvrsavanjeUsluge()); 
		c.add(Calendar.HOUR, -1);
		tr.setRokZaIzvrsavanjeUsluge(c.getTime());
		
		variables.put("tr", tr);
		System.out.println(tr.getRokZaPrimanjePonuda());
		System.out.println(tr.getRokZaIzvrsavanjeUsluge());
		taskService.complete(id,variables);
		return "eto";
	}
	
	@GetMapping("/startProcess")
	public String startProcess(HttpServletRequest request) {
		User u=userRepository.findByUsername(request.getHeader("username"));
		HashMap<String, Object> variables=new HashMap<>();
		variables.put("user", u);
		List<TenderResponse> ponude=new ArrayList<>();
		variables.put("ponude",ponude);
		variables.put("noT", 0);
		runtimeService.startProcessInstanceByKey("myProcess",variables);
		return "startan process";
	}
	
	@PostMapping("/odabir1/{id}")
	public String odibar1(@RequestBody String choice,@PathVariable String id) {
		Task t=taskService.createTaskQuery().taskId(id).singleResult();
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(t.getProcessInstanceId());
		System.out.println(t.getName());
		if(t.getName().equals("Da li korisnik zeli da se zahtev prosledi na manji broj firmi")) {
			if(choice.equals("Da"))
				variables.put("odabir1",true);
			else
				variables.put("odabir1",false);
		}else if(t.getName().equals("Da li proslediti na jos firmi")) {
			if(choice.equals("Da")) {
				//ako je vec 2 puta odabrao
				if((int)variables.get("noT")>2) {
					variables.put("odabir2",false);
					variables.put("ponude", new ArrayList<TenderResponse>());
					taskService.complete(id,variables);
					return "ne moze vise od 2";
				}
				variables.put("odabir2",true);
				//Produzavanje roka za 2 minuta
				TenderRequest tr=(TenderRequest) variables.get("tr");
				Calendar c = Calendar.getInstance(); 
				c.setTime(tr.getRokZaPrimanjePonuda()); 
				c.add(Calendar.MINUTE, 2);
				tr.setRokZaPrimanjePonuda(c.getTime());
				variables.put("tr",tr);
				System.out.println(tr.getRokZaPrimanjePonuda());
			}
			else {
				variables.put("ponude", new ArrayList<TenderResponse>());
				variables.put("odabir2",false);
			}
		}
		
		taskService.complete(id,variables);
		return "cabar";
	}
	

	@PostMapping("/tenderResponse/{id}")
	public String createTenderRequest(@RequestBody TenderResponse tr,@PathVariable String id) {
		Task t=taskService.createTaskQuery().taskId(id).singleResult();
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(t.getProcessInstanceId());
		@SuppressWarnings("unchecked")
		List<TenderResponse> lista=(List<TenderResponse>) variables.get("ponude");
		lista.add(tr);
		variables.put("ponude", lista);
		System.out.println(lista.size());
		taskService.complete(id,variables);
		return "eto";
	}
	
	@GetMapping("/getPonude/{id}")
	public List<TenderResponse> getPonude(@PathVariable String id){
		Task t=taskService.createTaskQuery().taskId(id).singleResult();
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(t.getProcessInstanceId());
		@SuppressWarnings("unchecked")
		List<TenderResponse> lista=(List<TenderResponse>) variables.get("ponude");
		return lista.stream().filter(u -> u.isPristanak()).collect(Collectors.toList());
	}
	
	@GetMapping("/no/{id}")
	public String no(@PathVariable String id){
		Task t=taskService.createTaskQuery().taskId(id).singleResult();
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(t.getProcessInstanceId());
		variables.put("odabir3", 3);
		variables.put("noT", (int)variables.get("noT")+1);
		taskService.complete(id, variables);
		return "no";
	}
	
}
