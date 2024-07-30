package com.amazon.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazon.demo.dto.ProductDto;
import com.amazon.demo.model.Product;
import com.amazon.demo.repo.ProductRepo;

// Annotation 
@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private Environment env;

	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
		if (uploadedFile.isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {

			byte[] bytes = uploadedFile.getBytes();

			UUID uuid = UUID.randomUUID();
			String uploadsLocation = env.getProperty("resource.uploads");
//			String uploadLocation = "/springboot/ibako-backend/products_demo_bk_v1/src/main/resources/uploads";
			String fileLocation = uploadsLocation + uuid + uploadedFile.getOriginalFilename();
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			File file = new File(fileLocation);
			return ResponseEntity.status(HttpStatus.OK).body(file.getName());

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

		}
	}
	
	@PostMapping("/uploadProduct")
	public ResponseEntity<?> uploadProduct(@ModelAttribute ProductDto productdto) {
		if (productdto.getFile().isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {

			byte[] bytes = productdto.getFile().getBytes();

			UUID uuid = UUID.randomUUID();
			String uploadsLocation = env.getProperty("resource.uploads");
//			String uploadLocation = "/springboot/ibako-backend/products_demo_bk_v1/src/main/resources/uploads";
			String fileLocation = uploadsLocation + uuid + productdto.getFile().getOriginalFilename();
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			File file = new File(fileLocation);
			
			File imageFile = new File(fileLocation);
			Product product = new Product();
			product.setName(productdto.getName());
			product.setDescription(productdto.getDescription());
			product.setPrice(productdto.getPrice());
			product.setCategory(productdto.getCategory());
			product.setImage(imageFile.getName());
			
			Product savedEntity = productRepo.save(product);
			
			return ResponseEntity.status(HttpStatus.OK).body(product);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

		}
	}

}