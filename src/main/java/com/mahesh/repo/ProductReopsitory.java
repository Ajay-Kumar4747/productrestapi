package com.mahesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.entities.Product;

public interface ProductReopsitory extends JpaRepository<Product, Integer> {

}
