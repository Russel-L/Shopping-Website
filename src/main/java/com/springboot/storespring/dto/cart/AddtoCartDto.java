package com.springboot.storespring.dto.cart;

import javax.validation.constraints.NotNull;

public class AddtoCartDto {
	
	int cart_id;
	@NotNull int  product_id;
	@NotNull int quantity;
	
	public AddtoCartDto() {
		
	}
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
