package com.proj.phase3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.phase3.exception.ResourceNotFoundException;
import com.proj.phase3.model.Product;
import com.proj.phase3.repository.ProductRepository;
import com.proj.phase3.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product updateProduct(Product product, long id) {
		Product existing = productRepo.findById(id).orElseThrow(() ->
					new ResourceNotFoundException("Product", "ID", id));
		
		existing.setPname(product.getPname());
		existing.setCategory(product.getCategory());
		
		productRepo.save(existing);
		
		return existing;
	}

	@Override
	public void deleteProduct(long id) {
		Product existing = productRepo.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Product", "ID", id));
		
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> findByCategory(String category) {
		List<Product> temp = productRepo.findByCategoryIs(category);
		
		if(temp.isEmpty()) {
			throw new ResourceNotFoundException("Products", "Category", category);
		}
		
		return temp;
	}

}
