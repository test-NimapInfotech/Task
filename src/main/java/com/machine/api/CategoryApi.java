package com.machine.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machine.request.category.AddRequest;
import com.machine.response.GenericResponse;
import com.machine.service.CategoryService;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/category")
@Log4j2
public class CategoryApi {

	@Autowired
	private CategoryService categoryServiceImpl;

	@PostMapping(value = "/add")
	public ResponseEntity<GenericResponse<?>> addCategory(@RequestBody AddRequest request) {
		System.out.println("request: "+request);

		GenericResponse<?> response = GenericResponse.builder().build();
		try {
			response = categoryServiceImpl.add(request);
			System.out.println("response: "+response);
			if (response != null && "success".equalsIgnoreCase(response.getResponseStatus())) {

				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} else if (response != null && "invalid".equalsIgnoreCase(response.getResponseStatus())) {
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

			}

			return new ResponseEntity<>(response, HttpStatus.NOT_MODIFIED);
		} catch (Exception e) {
			log.info("Exception {}", e);

		}
		response.setResponseStatus("error");
		response.setResponseStatus("Unable to process request");

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public GenericResponse<?> updateCategoryDetails() {

		return GenericResponse.builder().build();
	}

	public GenericResponse<?> getCategoryDetails() {

		return GenericResponse.builder().build();
	}

	public GenericResponse<?> deleteCategoryDetails() {

		return GenericResponse.builder().build();
	}
}
