package com.myRetail.bean;

import java.math.BigDecimal;

public class Product{
	private Long id;
	private String name;
	private CurrentPrice currentPrice;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

	public static class CurrentPrice {
		private BigDecimal value;
		private String currencyCode;
		public BigDecimal getValue() {
			return value;
		}
		public void setValue(BigDecimal value) {
			this.value = value;
		}
		public String getCurrencyCode() {
			return currencyCode;
		}
		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}
	}
}