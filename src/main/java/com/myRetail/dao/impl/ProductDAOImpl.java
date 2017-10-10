package com.myRetail.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.myRetail.dao.ProductDAO;
import com.myRetail.model.ProductModel;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void create(ProductModel product) {
		mongoTemplate.insert(product);
	}

	@Override
	public ProductModel findById(long id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, ProductModel.class);
	}

	@Override
	public void update(ProductModel product) {
		mongoTemplate.save(product);
	}

	@Override
	public int deleteById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
