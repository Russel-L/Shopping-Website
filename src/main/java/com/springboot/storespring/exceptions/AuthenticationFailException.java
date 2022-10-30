package com.springboot.storespring.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
	public AuthenticationFailException(String msg) {
		super(msg);
	}
}
