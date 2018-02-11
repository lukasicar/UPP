package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.task.Task;

public class MockTask {
	
	private String id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public static List<MockTask> convert(List<Task> tasks){
		ArrayList<MockTask> lista=new ArrayList<>();
		for(Task t : tasks) {
			MockTask mt=new MockTask();
			mt.setId(t.getId());
			mt.setName(t.getName());
			lista.add(mt);
		}
		return lista;
	}
}
