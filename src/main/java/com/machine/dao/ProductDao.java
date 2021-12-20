package com.machine.dao;

import com.machine.entity.Category;
import com.machine.entity.Product;

public interface ProductDao {
	Product add(Product categoryDetails);

	Product update(Product categoryDetails);

	Product getById(Long id);

	Long deleteById(Long id);
}
