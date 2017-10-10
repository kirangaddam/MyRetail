package com.myRetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myRetail.bean.Product;
import com.myRetail.model.ProductModel;
import com.myRetail.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/product")
@Api(value="MyRetail", description="MyRetail API Services")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Product Details By Id")
	public ResponseEntity<Product> findProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		if(product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update Product")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product request) {
		ProductModel productModel = productService.getProductModelById(id);
		if(productModel == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else if (request == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		productModel.setPrice(request.getCurrentPrice().getValue());
		productModel.setCurrencyCode(request.getCurrentPrice().getCurrencyCode());
		productService.update(productModel);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
