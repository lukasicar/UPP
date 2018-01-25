package com.example.demo.services;

import com.example.demo.model.MockUser;
import java.io.PrintStream;
import org.springframework.stereotype.Component;

@Component
public class CheckCredentialsService
{
  public boolean check(MockUser mu)
  {
    System.out.println("Check credentials");
    
    return true;
  }
}
