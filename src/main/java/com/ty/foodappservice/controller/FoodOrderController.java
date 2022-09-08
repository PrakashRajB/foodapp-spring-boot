package com.ty.foodappservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.service.FoodOrderService;

@RestController
@RequestMapping("/orders")
public class FoodOrderController {

	@Autowired
	private FoodOrderService orderService;

	@PostMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> placeOrder(@RequestBody FoodOrder foodOrder) {
		return orderService.placeOrder(foodOrder);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@RequestParam int id) {
		return orderService.getFoodOrderById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> cancelFoodOrderById(@PathVariable int id) {
		return orderService.cancelFoodOrderById(id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> updateOrder(@RequestBody FoodOrder foodOrder) {
		return orderService.placeOrder(foodOrder);
	}
}
