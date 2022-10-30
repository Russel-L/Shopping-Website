package com.springboot.storespring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.storespring.exceptions.ProductNotExistsException;
import com.springboot.storespring.model.Product;
import com.springboot.storespring.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> getProducts() {
		return productRepo.findAll();
	}
	
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	
	public void editProduct(int productId, Product updateProduct) {
		Product product = productRepo.getById(productId);
		product.setProduct_name(updateProduct.getProduct_name());
		product.setProduct_desc(updateProduct.getProduct_desc());
		product.setProduct_price(updateProduct.getProduct_price());
		productRepo.save(product);
	}
	
	public boolean findbyId(int productId) {
		return productRepo.findById(productId).isPresent();
	}

	public Product findbyId2(int product_id) {
		Optional<Product> optionalProduct = productRepo.findById(product_id);
		if (optionalProduct.isEmpty()) {
			throw new ProductNotExistsException("product id is invalid: " + product_id);
		}
		return optionalProduct.get();
		
	}

	public void deleteProduct(int product_id) {
		Optional<Product> optionalProduct = productRepo.findById(product_id);
		Product product = optionalProduct.get();
		if (optionalProduct.isEmpty()) {
			throw new ProductNotExistsException("product id does not exist");
		}
		productRepo.delete(product);
	}
}
