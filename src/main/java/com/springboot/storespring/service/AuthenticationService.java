package com.springboot.storespring.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.storespring.exceptions.AuthenticationFailException;
import com.springboot.storespring.model.AuthenticationToken;
import com.springboot.storespring.model.User;
import com.springboot.storespring.repository.TokenRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	TokenRepository tokenRepo;
	
	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		tokenRepo.save(authenticationToken);
		
	}

	public AuthenticationToken getToken(User user) {
		return tokenRepo.findByUser(user);
	}

	public void authenticate(String token) throws AuthenticationFailException {
        // null check
        if(Objects.isNull(token)) {
            // throw an exception
            throw new AuthenticationFailException("token not present");
        }
        if(Objects.isNull(getUser(token))) {
            throw new AuthenticationFailException("token not valid");
        }
    }

	public User getUser(String token) {
        final AuthenticationToken authenticationToken = tokenRepo.findByToken(token);
        if(Objects.isNull(authenticationToken)) {
            return null;
        }
        // authenticationToken is not null
        return authenticationToken.getUser();
    }
	
}
