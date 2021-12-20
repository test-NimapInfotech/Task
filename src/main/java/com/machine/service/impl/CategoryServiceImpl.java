package com.machine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.dao.CategoryDao;
import com.machine.dto.CategoryDto;
import com.machine.entity.Category;
import com.machine.request.category.AddRequest;
import com.machine.response.GenericResponse;
import com.machine.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public GenericResponse<?> add(AddRequest request) {
		Category newlyCreatedCategory = categoryDao.add(Category.builder().name(request.getName()).build());
		if (newlyCreatedCategory != null)

			return GenericResponse.builder().responseStatus("success")
					.data(CategoryDto.builder().id(newlyCreatedCategory.getId()).build()).build();

		return GenericResponse.builder().responseStatus("failed").message("unable to insert new category").build();
	}

	@Override
	public GenericResponse<?> update(CategoryDto dto) {
		if (dto.getId() > 0) {
			Category existingCategory = categoryDao.getById(dto.getId());
			if (existingCategory != null) {
				existingCategory.setId(dto.getId());
				Category updatedCategory = categoryDao.update(existingCategory);

				return GenericResponse.builder().responseStatus("success")
						.data(CategoryDto.builder().id(updatedCategory.getId()).build()).build();
			}
			return GenericResponse.builder().responseStatus("notfound").message("Category details not found").build();

		}
		return GenericResponse.builder().responseStatus("invalid").message("Invalid category details").build();

	}

	@Override
	public GenericResponse<?> getById(Long id) {
		if (id > 0) {
			Category existingCategory = categoryDao.getById(id);
			if (existingCategory != null) {
				return GenericResponse.builder().responseStatus("success")
						.data(CategoryDto.builder().id(existingCategory.getId()).build()).build();
			}
			return GenericResponse.builder().responseStatus("notfound").message("Category details not found").build();

		}
		return GenericResponse.builder().responseStatus("invalid").message("Invalid category details").build();
	}

	@Override
	public GenericResponse deleteById(Long id) {
		if (id > 0) {
			Category existingCategory = categoryDao.getById(id);
			if (existingCategory != null) {
				categoryDao.deleteById(id);

				return GenericResponse.builder().responseStatus("success")
						.data(CategoryDto.builder().id(existingCategory.getId()).build()).build();
			}
			return GenericResponse.builder().responseStatus("notfound").message("Category details not found").build();

		}
		return GenericResponse.builder().responseStatus("invalid").message("Invalid category details").build();

	}

	@Override
	public GenericResponse<?> getByName(String categoryName) {

		if (categoryName != null && "".equalsIgnoreCase(categoryName.trim())) {
			Category existingCategory = categoryDao.getByName(categoryName);

			return GenericResponse.builder().responseStatus("success").data(
					CategoryDto.builder().id(existingCategory.getId()).categoryName(existingCategory.getName()).build())
					.build();
		}

		return GenericResponse.builder().responseStatus("invalid").message("Invalid category details").build();
	}

}
