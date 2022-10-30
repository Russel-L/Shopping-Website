package com.springboot.storespring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "cartId")
	@JsonProperty("cart_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int cart_id;
	
	@Column(name = "created_date")
	Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user; 
	
	int quantity;
	
	public Cart() {
		
	}
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
