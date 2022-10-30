package com.springboot.storespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.storespring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
