package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;

@RestController
public class ProductController {
	
	@PostMapping("/products")
	public String addproduct(@RequestBody ProductEntity productEntity) {
		
		System.out.println(productEntity.getProductName());
		System.out.println(productEntity.getCatagory());
		System.out.println(productEntity.getQty());
		System.out.println(productEntity.getPrice());
		return " Done Chhe !!! ";
	}

}
