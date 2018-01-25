package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{
	
  private static final long serialVersionUID = 1L;
  
  @Id
  private String name;
  
  public String getName(){
    return this.name;
  }
  
  public void setName(String name){
    this.name = name;
  }
}
