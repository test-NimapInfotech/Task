package com.machine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@JsonInclude(value = Include.NON_EMPTY)
public class ProductDto {

	private Long id;
	private String productName;
	private String productPrice;
	private CategoryDto categoryDetails;
}
