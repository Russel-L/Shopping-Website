package com.springboot.storespring.dto.user;

public class SigninResponseDto {
	String status;
	String token;
	
	public SigninResponseDto(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}