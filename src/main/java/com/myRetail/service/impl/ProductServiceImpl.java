package com.myRetail.service.impl;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.myRetail.bean.Product;
import com.myRetail.bean.Product.CurrentPrice;
import com.myRetail.bean.RedskyProductResponse;
import com.myRetail.dao.ProductDAO;
import com.myRetail.model.ProductModel;
import com.myRetail.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	private static Logger LOG = Logger.getLogger(ProductServiceImpl.class.getName()); 
	public static final String REST_SERVICE_URI = "http://redsky.target.com/v2/pdp/tcin/";
	public static final String REST_SERVICE_PARAMS = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public Product getProductById(Long id) {
		Product product = null;
		try {
			RedskyProductResponse redskyProduct = restTemplate.getForObject(REST_SERVICE_URI + id + REST_SERVICE_PARAMS, RedskyProductResponse.class);
			ProductModel productModel = productDAO.findById(id);
			if(redskyProduct != null && redskyProduct.getProduct() != null) {
				product = new Product();
				product.setId(id);
				if(redskyProduct.getProduct().getItem() != null && redskyProduct.getProduct().getItem().getProductDescription() != null)
				product.setName(redskyProduct.getProduct().getItem().getProductDescription().getTitle());
			}
			if(productModel != null) {
				CurrentPrice currentPrice = new CurrentPrice();
				currentPrice.setValue(productModel.getPrice());
				currentPrice.setCurrencyCode(productModel.getCurrencyCode());
				product.setCurrentPrice(currentPrice);
			}
		} catch (RestClientException rce) {
			//do nothing for now
		}
		return product;
	}

	@Override
	public void create(ProductModel product) {
		productDAO.create(product);
	}

	@Override
	public ProductModel getProductModelById(Long id) {
		return productDAO.findById(id);
	}

	@Override
	public void update(ProductModel product) {
		productDAO.update(product);
	}
	
}
