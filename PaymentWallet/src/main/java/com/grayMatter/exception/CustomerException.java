package com.grayMatter.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomerException extends Exception {

	public CustomerException() {}
	public CustomerException(String message) {}
	
	

}
