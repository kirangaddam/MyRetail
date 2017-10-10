package com.myRetail.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class ProductModel {
	@Id
	private long id;
	private BigDecimal price;
	private String currencyCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public ProductModel(long id, BigDecimal price, String currencyCode) {
		super();
		this.id = id;
		this.price = price;
		this.currencyCode = currencyCode;
	}
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", price=" + price + ", currencyCode=" + currencyCode + "]";
	}
	
}
