package com.springboot.storespring.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.storespring.dto.ResponseDto;
import com.springboot.storespring.dto.user.SigninDto;
import com.springboot.storespring.dto.user.SigninResponseDto;
import com.springboot.storespring.dto.user.SignupDto;
import com.springboot.storespring.exceptions.AuthenticationFailException;
import com.springboot.storespring.exceptions.CustomException;
import com.springboot.storespring.model.AuthenticationToken;
import com.springboot.storespring.model.User;
import com.springboot.storespring.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Transactional
	public ResponseDto signUp(SignupDto signupDto) {
		
		if (Objects.nonNull(userRepo.findByEmail(signupDto.getEmail()))) {
            // we have an user
            throw new CustomException("user already present");
        }

		// hash the password
		
		String encryptedpassword = signupDto.getPassword();
		
		
		try { encryptedpassword = hashPassword(signupDto.getPassword()); 
		} catch  (NoSuchAlgorithmException e) { 
			e.printStackTrace();
		}
		 
		User user = new User(signupDto.getUserid(),signupDto.getFirstName(), signupDto.getLastName(),
				signupDto.getEmail(), encryptedpassword);
		userRepo.save(user);
		
		final AuthenticationToken authenticationToken = new AuthenticationToken(user);
		authenticationService.saveConfirmationToken(authenticationToken);
		
		ResponseDto responseDto = new ResponseDto("success", "user created successfully");
		return responseDto;
		
	}
	private String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return hash;
	}
	public SigninResponseDto signIn(SigninDto signinDto) {
		User user = userRepo.findByEmail(signinDto.getEmail());
		if (Objects.isNull(user)) {
			throw new AuthenticationFailException("user is not valid");
			
		}
		
		try {
			if (!user.getPassword().equals(hashPassword(signinDto.getPassword()))) {
				throw new AuthenticationFailException("wrong password");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		AuthenticationToken token = authenticationService.getToken(user);
		if (Objects.isNull(token)) {
			throw new CustomException("token is not present");
		}
		return new SigninResponseDto("success", token.getToken());
	}
}
