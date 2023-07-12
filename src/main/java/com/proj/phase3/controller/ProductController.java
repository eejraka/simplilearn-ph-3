package com.proj.phase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.phase3.model.Product;
import com.proj.phase3.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id){
		return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		return new ResponseEntity<String>("Product with ID : "+id+" successfully deleted.", HttpStatus.OK);
	}
	
	@GetMapping("{category}")
	public ResponseEntity<List<Product>> findByCategory(@PathVariable String category){
		return new ResponseEntity<List<Product>>(productService.findByCategory(category), HttpStatus.FOUND);
	}
}
