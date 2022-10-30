package com.springboot.storespring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_id")
	@JsonProperty("first_name")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int user_id;
	
    @Column(name = "firstName")
    @JsonProperty("first_name")
	String first_name;
	
	@Column(name = "lastName")
    @JsonProperty("last_name")
    String last_name;
	
	@Column(name = "email")
    @JsonProperty("email")
    String email;
	
	@Column(name = "password")
    @JsonProperty("password")
    String password;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int userid,String first_name, String last_name, String email, String password) {
		super();
		this.user_id = userid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}
	
	public User() {
		
	}
	
	
}
