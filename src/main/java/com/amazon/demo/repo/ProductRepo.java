package com.amazon.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.demo.model.Product;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Integer> {

}
