package com.machine.service;

import com.machine.dto.CategoryDto;
import com.machine.request.category.AddRequest;
import com.machine.response.GenericResponse;

public interface CategoryService {

	GenericResponse add(AddRequest request);

	GenericResponse update(CategoryDto dto);

	GenericResponse getById(Long id);

	GenericResponse deleteById(Long id);
	
	GenericResponse<?> getByName(String categoryName);

}
