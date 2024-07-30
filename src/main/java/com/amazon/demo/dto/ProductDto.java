package com.amazon.demo.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
	
	private String name;
	private String description;
	private double price;
	private String image;
	private MultipartFile file;
	private String category;
	
	public ProductDto() {}
	
	public ProductDto(String name, String description, double price, String image, MultipartFile file,
			String category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.file = file;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

}
