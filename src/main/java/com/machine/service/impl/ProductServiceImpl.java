package com.machine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.machine.dao.CategoryDao;
import com.machine.dao.ProductDao;
import com.machine.dto.CategoryDto;
import com.machine.dto.ProductDto;
import com.machine.entity.Category;
import com.machine.entity.Product;
import com.machine.request.product.AddRequest;
import com.machine.request.product.UpdateRequest;
import com.machine.response.GenericResponse;
import com.machine.service.CategoryService;
import com.machine.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDaoImpl;

	@Autowired
	private CategoryService categorySeriveImpl;

	@Override
	public GenericResponse<?> add(AddRequest addRequest) {
		ProductDto.builder().productName(addRequest.getProductName()).build();

		if (addRequest.getProductName() != null && addRequest.getCategoryName() != null
				&& !("".equalsIgnoreCase(addRequest.getProductName().trim())
						|| "".equalsIgnoreCase(addRequest.getCategoryName().trim()))) {
			GenericResponse<?> categoryDetails = categorySeriveImpl.getByName(addRequest.getCategoryName());

			if (categoryDetails != null) {
				Product newlyCreatedProduct = productDaoImpl.add(Product.builder()
						.name(addRequest.getProductName().trim()).price(addRequest.getProcductPrice())
						.categoryId((Category) categoryDetails.getData()).build());

				if (newlyCreatedProduct != null)

					return GenericResponse.builder().responseStatus("success")
							.data(CategoryDto.builder().id(newlyCreatedProduct.getId()).build()).build();
			}
			return GenericResponse.builder().responseStatus("failed").message("unable to insert new category").build();
		}
		return GenericResponse.builder().responseStatus("invalid").message("inavlid product details").build();

	}

	@Override
	public GenericResponse<?> update(UpdateRequest request) {
		if (request.getId() > 0) {
			Product existingProduct = productDaoImpl.getById(request.getId());
			if (existingProduct != null) {
				existingProduct.setId(request.getId());
				existingProduct.setPrice(existingProduct.getPrice());
				existingProduct.setCategoryId(Category.builder().name(request.getCategoryName()).build());

				Product updatedProduct = productDaoImpl.update(existingProduct);
				Category categoryDetails = updatedProduct.getCategoryId();
				CategoryDto categoryDto = CategoryDto.builder().id(categoryDetails.getId())
						.categoryName(categoryDetails.getName()).build();

				return GenericResponse.builder().responseStatus("success")
						.data(ProductDto.builder().id(updatedProduct.getId()).productName(updatedProduct.getName())
								.productPrice(updatedProduct.getPrice()).categoryDetails(categoryDto).build())
						.build();
			}
			return GenericResponse.builder().responseStatus("notfound").message("Category details not found").build();

		}
		return GenericResponse.builder().responseStatus("invalid").message("Invalid category details").build();
	}

	@Override
	public GenericResponse<?> getById(Long id) {
		if (id > 0) {
			Product existingProduct = productDaoImpl.getById(id);
			if (existingProduct != null) {
				return GenericResponse.builder().responseStatus("success")
						.data(CategoryDto.builder().id(existingProduct.getId()).build()).build();
			}
			return GenericResponse.builder().responseStatus("notfound").message("Category details not found").build();

		}
		return GenericResponse.builder().responseStatus("invalid").message("Invalid category details").build();
	}

	@Override
	public GenericResponse<?> deleteById(Long id) {
		if (id > 0) {
			Product existingProduct = productDaoImpl.getById(id);
			if (existingProduct != null) {
				productDaoImpl.deleteById(id);

				return GenericResponse.builder().responseStatus("success")
						.data(CategoryDto.builder().id(existingProduct.getId()).build()).build();
			}
			return GenericResponse.builder().responseStatus("notfound").message("Category details not found").build();

		}
		return GenericResponse.builder().responseStatus("invalid").message("Invalid category details").build();
	}
}
