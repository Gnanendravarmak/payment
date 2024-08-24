package com.grayMatter.exception;

public class ResourceNotFoundException extends Exception {
	String msg;

	public ResourceNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
