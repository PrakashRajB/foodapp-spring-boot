package com.ty.foodappservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.FoodOrderDao;
import com.ty.foodappservice.dto.FoodOrder;
import com.ty.foodappservice.dto.Item;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.exception.IdNotFoundException;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao orderDao;

	public ResponseEntity<ResponseStructure<FoodOrder>> placeOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		List<Item> items = foodOrder.getItems();
		double totalCost = 0;
		for (Item item : items) {
			totalCost += item.getCost() * item.getQuantity();
		}
		foodOrder.setTotalCost(totalCost);
		foodOrder.setOrderDateTime(LocalDateTime.now());

		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(orderDao.placeOrder(foodOrder));

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		FoodOrder foodOrder = orderDao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Food Order Id : "+id+" Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<String>> cancelFoodOrderById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (orderDao.cancelOrderById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("FoodOrder ID : " + id + " Deleted successfully");
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Food Order Id : "+id+" Not Found");
		}

	}
}
