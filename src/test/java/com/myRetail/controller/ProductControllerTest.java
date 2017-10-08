package com.myRetail.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myRetail.bean.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet-test.xml")
public class ProductControllerTest {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/";

	@Autowired
	private ProductController productController;
	
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetCountries() throws JsonProcessingException {
		ResponseEntity<Product> product = productController.getProductById(13860428L);
		Assert.assertEquals("The Big Lebowski (Blu-ray)", product.getBody().getName());
		System.out.println(mapper.writeValueAsString(product));
	}

}
