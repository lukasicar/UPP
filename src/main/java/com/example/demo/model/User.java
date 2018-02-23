package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
//@Table(name="UUSER")
public class User
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  private String username;
  private String ime;
  private String password;
  private String mail;
  private String address;
  private long postanskiBroj;
  private String mjesto;
  private Type type;
  private long longitude;
  private long latitude;
  private long udaljenost;
  private boolean activated;
  //@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
  //private List<Category> categories;
  @ManyToOne
  private Category category;
  
  private ArrayList<Integer> ocjene=new ArrayList<Integer>();
  
  public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public static enum Type
  {
    regular,  firm;
  }
  
  public long getUdaljenost()
  {
    return this.udaljenost;
  }
  
  public void setUdaljenost(long udaljenost)
  {
    this.udaljenost = udaljenost;
  }
  /*
  public List<Category> getCategories()
  {
    return this.categories;
  }
  
  public void setCategories(List<Category> categories)
  {
    this.categories = categories;
  }*/
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getIme()
  {
    return this.ime;
  }
  
  public void setIme(String ime)
  {
    this.ime = ime;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getMail()
  {
    return this.mail;
  }
  
  public void setMail(String mail)
  {
    this.mail = mail;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public long getPostanskiBroj()
  {
    return this.postanskiBroj;
  }
  
  public void setPostanskiBroj(long postanskiBroj)
  {
    this.postanskiBroj = postanskiBroj;
  }
  
  public String getMjesto()
  {
    return this.mjesto;
  }
  
  public void setMjesto(String mjesto)
  {
    this.mjesto = mjesto;
  }
  
  public Type getType()
  {
    return this.type;
  }
  
  public void setType(Type type)
  {
    this.type = type;
  }
  
  public long getLatitude()
  {
    return this.latitude;
  }
  
  public void setLatitude(long latitude)
  {
    this.latitude = latitude;
  }
  
  public long getLongitude()
  {
    return this.longitude;
  }
  
  public void setLongitude(long longitude)
  {
    this.longitude = longitude;
  }

public boolean isActivated() {
	return activated;
}

public void setActivated(boolean activated) {
	this.activated = activated;
}

public ArrayList<Integer> getOcjene() {
	return ocjene;
}

public void setOcjene(ArrayList<Integer> ocjene) {
	this.ocjene = ocjene;
}
}
