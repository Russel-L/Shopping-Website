package com.springboot.storespring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name = "productID")
	@JsonProperty("product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int product_id;
	
    @Column(name = "productName")
    @JsonProperty("product_name")
	String product_name;
	
	@Column(name = "productDesc")
    @JsonProperty("product_desc")
    String product_desc;
	
	@Column(name = "productPrice")
    @JsonProperty("product_price")
    double product_price;
	
	public Product (String name, String desc, double price) {
		this.product_name = name;
		this.product_desc = desc;
		this.product_price = price;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Product() {
		
	}
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
}
