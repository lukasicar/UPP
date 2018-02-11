package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
}
