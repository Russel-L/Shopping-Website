package com.springboot.storespring.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tokens")
public class AuthenticationToken {
	@Id
	@Column(name = "tokenId")
	@JsonProperty("token_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tokenId;
	
	String token;
	
    @Column(name = "createdDate")
    @JsonProperty("created_date")
	Date createdDate;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	User user;

	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public AuthenticationToken(User user) {
		this.user = user;
		this.createdDate = new Date();
		this.token = UUID.randomUUID().toString();
	}
	
	public AuthenticationToken() {
		
	}
}