package com.machine.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder@ToString
@JsonInclude(value = Include.NON_EMPTY)
public class GenericResponse<T> {

	private T data;
	private String message;
	private String responseStatus;
}
