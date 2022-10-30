package com.springboot.storespring.exceptions;

public class ProductNotExistsException extends IllegalArgumentException {
	
	public ProductNotExistsException(String msg) {
		super(msg);
	}
}
