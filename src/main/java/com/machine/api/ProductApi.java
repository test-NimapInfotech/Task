package com.machine.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machine.request.product.AddRequest;
import com.machine.request.product.UpdateRequest;
import com.machine.response.GenericResponse;
import com.machine.service.ProductService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductApi {

	@Autowired
	private ProductService productServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<GenericResponse<?>> addCategory(@RequestBody AddRequest requeest) {
		log.info("request: {}", requeest);
		GenericResponse<?> response = GenericResponse.builder().build();
		try {
			response = productServiceImpl.add(requeest);
			if (response != null && "success".equalsIgnoreCase(response.getResponseStatus())) {

				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} else if (response != null && "invalid".equalsIgnoreCase(response.getResponseStatus())) {
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

			}

			return new ResponseEntity<>(response, HttpStatus.NOT_MODIFIED);
		} catch (Exception e) {
			log.info("Exception :" + e);
		}
		response.setResponseStatus("error");
		response.setMessage("Unable to process request");

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<GenericResponse<?>> updateCategoryDetails(@RequestBody UpdateRequest request) {

		GenericResponse<?> response = GenericResponse.builder().build();
		try {
			response = productServiceImpl.update(request);
			if (response != null && "success".equalsIgnoreCase(response.getResponseStatus())) {

				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} else if (response != null && "invalid".equalsIgnoreCase(response.getResponseStatus())) {
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

			}

			return new ResponseEntity<>(response, HttpStatus.NOT_MODIFIED);
		} catch (Exception e) {
			System.out.println("Exception: " + e);

		}
		response.setResponseStatus("error");
		response.setResponseStatus("Unable to process request");

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public GenericResponse<?> getCategoryDetails() {

		return GenericResponse.builder().build();
	}

	public GenericResponse<?> deleteCategoryDetails() {

		return GenericResponse.builder().build();
	}
}
