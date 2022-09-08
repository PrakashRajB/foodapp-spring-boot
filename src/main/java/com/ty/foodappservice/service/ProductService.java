package com.ty.foodappservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodappservice.dao.ProductDao;
import com.ty.foodappservice.dto.Product;
import com.ty.foodappservice.dto.ResponseStructure;
import com.ty.foodappservice.exception.IdNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(productDao.saveProduct(product));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {

		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		List<Product> products = productDao.getAllProducts();
		if (products.isEmpty()) {
			responseStructure.setStatus(HttpStatus.NO_CONTENT.value());
			responseStructure.setMessage("NO CONTENT");
			responseStructure.setData(products);
			return new ResponseEntity<>(responseStructure, HttpStatus.NO_CONTENT);
		} else {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(products);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {

		ResponseStructure<Product> responseStructure = new ResponseStructure<>();

		Product product = productDao.getProductById(id);
		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(product);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Product ID : "+id+" Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteProductById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();

		if (productDao.deleteProductById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("Product ID : " + id + " Deleted Succesfully");
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Product ID : "+id+" Not Found");
		}
	}

}
