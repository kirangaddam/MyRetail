package com.myRetail.service;

import com.myRetail.bean.Product;
import com.myRetail.model.ProductModel;

public interface ProductService {
	
	public Product getProductById(Long id);
	
	public void create(ProductModel product);
	
	public ProductModel getProductModelById(Long id);
	
	public void update(ProductModel product);
}
