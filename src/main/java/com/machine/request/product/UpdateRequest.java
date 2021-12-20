package com.machine.request.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateRequest {

	private Long id;
	private String procuctName;
	private String procductPrice;
	private String categoryName;
}
