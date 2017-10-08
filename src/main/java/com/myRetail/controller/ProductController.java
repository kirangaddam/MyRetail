package com.myRetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myRetail.bean.Product;
import com.myRetail.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		if(product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
