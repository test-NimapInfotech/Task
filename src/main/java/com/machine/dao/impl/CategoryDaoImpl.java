package com.machine.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.machine.dao.CategoryDao;
import com.machine.entity.Category;
import com.machine.repositry.CategoryRepositry;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private CategoryRepositry categoryRepositry;

	@Override
	public Category add(Category categoryDetails) {
		return categoryRepositry.save(categoryDetails);
	}

	@Override
	public Category update(Category categoryDetails) {

		return categoryRepositry.save(categoryDetails);
	}

	@Override
	public Long deleteById(Long id) {
		categoryRepositry.deleteById(id);

		return id;
	}

	@Override
	public Category getById(Long id) {

		return categoryRepositry.getById(id);
	}

	@Override
	public Category getByName(String categoryName) {
	
		return categoryRepositry.getByName(categoryName);
	}

}
