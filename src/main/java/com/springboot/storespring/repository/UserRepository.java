package com.springboot.storespring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.storespring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
}
