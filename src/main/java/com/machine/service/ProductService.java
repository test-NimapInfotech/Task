package com.machine.service;

import com.machine.dto.ProductDto;
import com.machine.request.product.AddRequest;
import com.machine.request.product.UpdateRequest;
import com.machine.response.GenericResponse;

public interface ProductService {

	GenericResponse<?> add(AddRequest request);

	GenericResponse<?> update(UpdateRequest request);

	GenericResponse<?> getById(Long id);

	GenericResponse<?> deleteById(Long id);

}
