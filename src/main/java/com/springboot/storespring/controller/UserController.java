package com.springboot.storespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storespring.dto.ResponseDto;
import com.springboot.storespring.dto.user.SigninDto;
import com.springboot.storespring.dto.user.SigninResponseDto;
import com.springboot.storespring.dto.user.SignupDto;
import com.springboot.storespring.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public ResponseDto signup(@RequestBody SignupDto signupDto) {
		return userService.signUp(signupDto);
	}

	@PostMapping("/signin")
	public SigninResponseDto signIn(@RequestBody SigninDto signinDto) {
		return userService.signIn(signinDto);
	}
}
