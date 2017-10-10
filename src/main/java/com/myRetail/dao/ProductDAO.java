package com.myRetail.dao;

import com.myRetail.model.ProductModel;

public interface ProductDAO {
	public void create(ProductModel product);
	
	public ProductModel findById(long id);
	
	public void update(ProductModel product);
	
	public int deleteById(long id);
}
