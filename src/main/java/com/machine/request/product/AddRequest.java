package com.machine.request.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddRequest {

	private String productName;
	private String procductPrice;
	private String categoryName;
}
