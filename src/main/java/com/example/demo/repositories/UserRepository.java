package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;
import com.example.demo.model.User.Type;

public interface UserRepository extends JpaRepository<User, String>{
		
	List<User> findByType(Type type);
	User findByUsername(String username);
}
