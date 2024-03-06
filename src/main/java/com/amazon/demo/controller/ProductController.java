package com.amazon.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.demo.model.Product;
import com.amazon.demo.repo.ProductRepo;

@RestController
@RequestMapping("/product")

public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;

	@PostMapping("/set")
//	public ResponseEntity<?> setProduct(){
	public ResponseEntity<?> setProduct(@RequestBody Product product){
	
		
		
//		Product savedEntity = productRepo.save(product);
		Product savedEntity = productRepo.saveAndFlush(product);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(savedEntity);
	}
	
}
