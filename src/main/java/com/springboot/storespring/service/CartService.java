package com.springboot.storespring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.storespring.dto.cart.AddtoCartDto;
import com.springboot.storespring.dto.cart.CartDto;
import com.springboot.storespring.dto.cart.CartItemDto;
import com.springboot.storespring.exceptions.CustomException;
import com.springboot.storespring.model.Cart;
import com.springboot.storespring.model.Product;
import com.springboot.storespring.model.User;
import com.springboot.storespring.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartRepository cartRepo;
	public void addtoCart(AddtoCartDto addtoCartDto, User user) {
		Product product = productService.findbyId2(addtoCartDto.getProduct_id());

		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setUser(user);
		cart.setQuantity(addtoCartDto.getQuantity());
		cart.setCreatedDate(new Date());
		
		cartRepo.save(cart);
	}
	public CartDto listCartItems(User user) {
		List<Cart> cartList = cartRepo.findAllByUserOrderByCreatedDateDesc(user);
		List<CartItemDto> cartItems = new ArrayList<>();
		double totalCost = 0;
		for (Cart cart: cartList) {
			CartItemDto cartItemDto = new CartItemDto(cart);
			totalCost += cartItemDto.getQuantity() * cart.getProduct().getProduct_price();
			cartItems.add(cartItemDto);
		}
		
		CartDto cartDto = new CartDto();
		cartDto.setTotalCost(totalCost);
		cartDto.setCartItems(cartItems);
		return cartDto;
	}
	public void deleteCartItem(int itemId, User user) {
		Optional<Cart> optionalCart = cartRepo.findById(itemId);
		if (optionalCart.isEmpty()) {
			throw new CustomException("cart item id is invalid: " + itemId);
		}
		Cart cart = optionalCart.get();
		
		if (cart.getUser() != user) {
			throw new CustomException("cart item does not belong to user: " + itemId);
		}
		cartRepo.delete(cart);
	}

}
