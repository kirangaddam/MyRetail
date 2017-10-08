package com.myRetail.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RedskyProductResponse {
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static class Product {
		private Item item;

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}
		
	}
	
	 public static class Item {
		@JsonProperty("product_description")
		private ProductDescription productDescription;
		
		public ProductDescription getProductDescription() {
			return productDescription;
		}

		public void setProductDescription(ProductDescription productDescription) {
			this.productDescription = productDescription;
		}

		 public static class ProductDescription {
			private String title;

			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
		}
	}
}
