package com.springboot.storespring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.storespring.common.ApiResponse;
import com.springboot.storespring.model.Product;
import com.springboot.storespring.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> fetchProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping("/addProducts")
    public ResponseEntity<ApiResponse> addProducts(@RequestBody Product payload) {
        productService.addProduct(payload);
        return new ResponseEntity<>(new ApiResponse(true, "a new product is created"), HttpStatus.CREATED);
    }

    @PostMapping("/updateProducts/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") int productId,
            @RequestBody Product product) {
        System.out.println("product name: " + productId);
        if (!productService.findbyId(productId)) {
            return new ResponseEntity<>(new ApiResponse(false, "product does not exist"), HttpStatus.NOT_FOUND);
        }
        productService.editProduct(productId, product);
        return new ResponseEntity<>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProducts/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") int itemId) {
        productService.deleteProduct(itemId);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been removed"), HttpStatus.OK);
    }
}