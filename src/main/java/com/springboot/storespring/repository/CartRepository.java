package com.springboot.storespring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.storespring.model.Cart;
import com.springboot.storespring.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
