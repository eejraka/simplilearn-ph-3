package com.proj.phase3.service;

import java.util.List;

import com.proj.phase3.model.Product;

public interface ProductService {
	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product updateProduct(Product product, long id);
	void deleteProduct(long id);
	List<Product> findByCategory(String category);
}
