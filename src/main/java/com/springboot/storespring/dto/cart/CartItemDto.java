package com.springboot.storespring.dto.cart;

import com.springboot.storespring.model.Cart;
import com.springboot.storespring.model.Product;

public class CartItemDto {
	int cartitem_id;
	int quantity;
	Product product;
	
	public CartItemDto() {
	}

	public int getCartitem_id() {
		return cartitem_id;
	}

	public void setCartitem_id(int cartitem_id) {
		this.cartitem_id = cartitem_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public CartItemDto(Cart cart) {
		this.cartitem_id = cart.getCart_id();
		this.quantity = cart.getQuantity();
		this.product = cart.getProduct();
	}

}
