package com.proj.phase3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.phase3.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByCategoryIs(String category);
}
