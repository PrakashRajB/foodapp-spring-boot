package com.ty.foodappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappservice.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
