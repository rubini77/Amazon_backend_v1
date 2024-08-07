package com.amazon.demo.service.impl;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.demo.model.Product;
import com.amazon.demo.repo.ProductRepo;
import com.amazon.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductRepo productRepo;
		
	@Override
	public List<Product> getProduct() {
		return productRepo.findAll();
		}

	@Override
	public Product deleteProduct(int id) {
		Product product = productRepo.findById(id).get();
		if(product!=null)
		productRepo.delete(product);
		
		return product;
	}
	

}
