package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.entity.ProductEntity;
import com.repository.ProductRepository;


@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/products")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		productRepository.save(productEntity);
		return productEntity;
	}
	
	@GetMapping("/products")
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		return products;
	}
	
	@GetMapping("/products/{productId}")
	public ProductEntity geProductByID(@PathVariable("productId") Integer productId) {
		Optional<ProductEntity> op = productRepository.findById(productId);
		if (op.isEmpty()) {
			return null;
			} else {
				ProductEntity productEntity = op.get();
				return productEntity;
		}
	}
	
	
	@GetMapping("/productbyid")
	public ProductEntity geProductByIDparam(@RequestParam("productId") Integer productId) {
		Optional<ProductEntity> op = productRepository.findById(productId);
		if (op.isEmpty()) {
			return null;
			} else {
				ProductEntity productEntity = op.get();
				return productEntity;
		}
	}
	
}

