package com.example.demo.services;

import com.example.demo.model.MockUser;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckCredentialsService
{
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean check(MockUser mu)
	{
		System.out.println("Check credentials");
		System.out.println(mu.getUsername());
	    if(userRepository.findByUsername(mu.getUsername())==null) {
	    	if(userRepository.findByMail(mu.getMail())==null) {
	    		User u=new User();
	    		u.setActivated(false);
	    		u.setAddress(mu.getAddress());
	    		u.setCategory(mu.getCategory());
	    		u.setIme(mu.getIme());
	    		u.setLatitude(mu.getLatitude());
	    		u.setLongitude(mu.getLongitude());
	    		u.setUsername(mu.getUsername());
	    		u.setMail(mu.getMail());
	    		u.setMjesto(mu.getMjesto());
	    		u.setPassword(mu.getPassword());
	    		u.setPostanskiBroj(mu.getPostanskiBroj());
	    		u.setCategory(mu.getCategory());
	    		u.setType(mu.getType());
	    		u.setUdaljenost(mu.getUdaljenost());
	    		userRepository.save(u);
	    		return true;
	    	}
	    	System.out.println("los mail");
	    }
	    System.out.println("username vec postoji");
	    return false;
	}
	  
	public void confirmCredentials(String username) {
		User u=userRepository.findByUsername(username);
		u.setActivated(true);
		userRepository.save(u);
		System.out.println("korisnik snimljen u bazu");
	}
	  
	public void neceProci(String username) {
		User u=userRepository.findByUsername(username);
		userRepository.delete(u);
		System.out.println("Korisnik se brise iz servisa");
	}
  
}
