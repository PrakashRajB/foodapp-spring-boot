package com.ty.foodappservice.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepository orderRepository;

	public FoodOrder placeOrder(FoodOrder foodOrder) {
		return orderRepository.save(foodOrder);
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional = orderRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean cancelOrderById(int id) {
		Optional<FoodOrder> optional = orderRepository.findById(id);
		if (optional.isPresent()) {
			orderRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}
}
