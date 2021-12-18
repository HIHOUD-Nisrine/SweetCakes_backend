package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class Users {
	@Id
	private String username;

	@Column(name = "password")
	private String password;
	@Column(name = "full_name")
	private String full_name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "Address")
	private String Address;

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Users(){}
	public Users(String username, String password, String full_name, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.full_name = full_name;
		this.phone = phone;
		Address = address;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
