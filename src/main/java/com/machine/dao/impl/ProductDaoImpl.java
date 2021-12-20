package com.machine.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.machine.dao.ProductDao;
import com.machine.entity.Product;
import com.machine.repositry.ProductRepositry;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepositry productRepositry;

	@Override
	public Product add(Product productDetails) {
		return productRepositry.save(productDetails);
	}

	@Override
	public Product update(Product productDetails) {
		return productRepositry.save(productDetails);
	}

	@Override
	public Product getById(Long id) {
		return productRepositry.getById(id);
	}

	@Override
	public Long deleteById(Long id) {
		productRepositry.deleteById(id);

		return id;
	}
}
