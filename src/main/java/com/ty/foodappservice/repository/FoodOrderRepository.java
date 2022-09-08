package com.ty.foodappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappservice.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{

}
