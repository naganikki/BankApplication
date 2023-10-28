package com.web.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String resourceName,String fieldName,String fieldValue) {
		super("%s not found with given input data %s:%s".formatted(resourceName, fieldName, fieldValue));
	}

}
