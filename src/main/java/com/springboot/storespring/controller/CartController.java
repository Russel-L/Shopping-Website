package com.springboot.storespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storespring.common.ApiResponse;
import com.springboot.storespring.dto.cart.AddtoCartDto;
import com.springboot.storespring.dto.cart.CartDto;
import com.springboot.storespring.model.User;
import com.springboot.storespring.service.AuthenticationService;
import com.springboot.storespring.service.CartService;
import com.springboot.storespring.service.ProductService;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	ProductService productService;

	@PostMapping("/addCart")
	public ResponseEntity<ApiResponse> addtoCart(@RequestBody AddtoCartDto addtoCartDto,
			@RequestParam("token") String token) {
		authenticationService.authenticate(token);
		User user = authenticationService.getUser(token);

		cartService.addtoCart(addtoCartDto, user);
		return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
	}

	@GetMapping("/cart")
	public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
		authenticationService.authenticate(token);
		User user = authenticationService.getUser(token);

		CartDto cartDto = cartService.listCartItems(user);
		return new ResponseEntity<>(cartDto, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCart/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemId,
			@RequestParam("token") String token) {
		authenticationService.authenticate(token);
		User user = authenticationService.getUser(token);
		cartService.deleteCartItem(itemId, user);
		return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
	}

}
