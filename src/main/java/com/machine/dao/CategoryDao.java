package com.machine.dao;

import com.machine.entity.Category;

public interface CategoryDao {
	Category add(Category categoryDetails);

	Category update(Category categoryDetails);

	Category getById(Long id);

	Long deleteById(Long id);
	
	Category getByName(String categoryName);
}
