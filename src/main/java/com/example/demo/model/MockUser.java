package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class MockUser
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String username;
  private String ime;
  private String password;
  private String mail;
  private String address;
  private long postanskiBroj;
  private String mjesto;
  private User.Type type;
  private long longitude;
  private long latitude;
  private long udaljenost;
  @Transient
  private Category category;
  
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
  
  public User.Type getType()
  {
    return this.type;
  }
  
  public void setType(User.Type type)
  {
    this.type = type;
  }
  
  public long getLongitude()
  {
    return this.longitude;
  }
  
  public void setLongitude(long longitude)
  {
    this.longitude = longitude;
  }
  
  public long getLatitude()
  {
    return this.latitude;
  }
  
  public void setLatitude(long latitude)
  {
    this.latitude = latitude;
  }
  
  public long getUdaljenost()
  {
    return this.udaljenost;
  }
  
  public void setUdaljenost(long udaljenost)
  {
    this.udaljenost = udaljenost;
  }

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
