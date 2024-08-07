package com.amazon.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.demo.model.Product;
import com.amazon.demo.repo.ProductRepo;
import com.amazon.demo.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductService productservice;
	@PostMapping("/set")
//	public ResponseEntity<?> setProduct(){
	public ResponseEntity<?> setProduct(@RequestBody Product product){
	
		
		
//		Product savedEntity = productRepo.save(product);
		Product savedEntity = productRepo.saveAndFlush(product);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(savedEntity);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Product>> getProduct(){
		List<Product> datas = productservice.getProduct();
		
		return ResponseEntity.status(HttpStatus.OK).body(datas);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		
		Product product = productservice.deleteProduct(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Data Deleted" + product);
		
	}
	
//	@DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
//        Product deletedProduct = productservice.deleteProduct(id);
//        if (deletedProduct != null) {
//            return ResponseEntity.ok("Data Deleted: " + deletedProduct);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
