package com.springboot.storespring.exceptions;


public class CustomException extends IllegalArgumentException {
	public CustomException(String msg) {
		super(msg);
	}
	
}
