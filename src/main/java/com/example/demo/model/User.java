package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

public class User
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String username;
  private String ime;
  private String password;
  private String mail;
  private String address;
  private long postanskiBroj;
  private String mesto;
  private Type type;
  private long longitude;
  private long latitude;
  private long udaljenost;
  private List<Category> categories;
  
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
  
  public List<Category> getCategories()
  {
    return this.categories;
  }
  
  public void setCategories(List<Category> categories)
  {
    this.categories = categories;
  }
  
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
  
  public String getMesto()
  {
    return this.mesto;
  }
  
  public void setMesto(String mesto)
  {
    this.mesto = mesto;
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
}
