package com.springboot.storespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.storespring.model.AuthenticationToken;
import com.springboot.storespring.model.User;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	
	AuthenticationToken findByUser(User user);
	AuthenticationToken findByToken(String token);
}
