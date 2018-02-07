package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable{
	
  private static final long serialVersionUID = 1L;
  
  @Id
  private String name;
  
  //@ManyToOne
  /*@OneToMany(mappedBy = "category")
  private List<User> users;*/
  
  public String getName(){
    return this.name;
  }
  
  public void setName(String name){
    this.name = name;
  }
}
