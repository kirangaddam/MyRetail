package com.myRetail.controller;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myRetail.bean.Product;
import com.myRetail.bean.Product.CurrentPrice;
import com.myRetail.model.ProductModel;
import com.myRetail.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet-test.xml")
@WebAppConfiguration
public class ProductControllerTest {
	private static Logger LOG = Logger.getLogger(ProductControllerTest.class.getName());
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/";

	@Autowired
	private ProductController productController;
	
	@Autowired
	private ProductService productService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void createProducts() {
		ProductModel productModel1 = new ProductModel(13860428, new BigDecimal(9.50), "USD");
		ProductModel productModel2 = new ProductModel(13860429, new BigDecimal(10.50), "USD");
		ProductModel productModel3 = new ProductModel(13860430, new BigDecimal(11.50), "USD");
		ProductModel productModel4 = new ProductModel(13860431, new BigDecimal(12.50), "USD");
		ProductModel productModel5 = new ProductModel(13860432, new BigDecimal(13.50), "USD");
		productService.create(productModel1);
		productService.create(productModel2);
		productService.create(productModel3);
		productService.create(productModel4);
		productService.create(productModel5);
	}

	@Test
	public void findProductById() throws JsonProcessingException {
		ResponseEntity<Product> product = productController.findProductById(13860428L);
		Assert.assertEquals("The Big Lebowski (Blu-ray)", product.getBody().getName());
		LOG.info(mapper.writeValueAsString(product));
	}
	
	@Test
	public void updateProduct() throws JsonProcessingException {
		Product product = new Product();
		product.setId(13860428L);
		CurrentPrice currentPrice = new CurrentPrice();
		currentPrice.setValue(new BigDecimal(20.50));
		currentPrice.setCurrencyCode("USD");
		product.setCurrentPrice(currentPrice);
		ResponseEntity<Product> response  = productController.update(13860428L, product);
		LOG.info(mapper.writeValueAsString(response));
	}
	
	

}
