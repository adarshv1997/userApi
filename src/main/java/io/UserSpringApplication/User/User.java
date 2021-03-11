package io.UserSpringApplication.User;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the user model")
//@JsonFilter("passwordfilter")
public class User {
	
	@ApiModelProperty(notes = "The unique id of the user")
	String id;
	@ApiModelProperty(notes = "The name of the user")
	String name;
	@ApiModelProperty(notes = "The address of the user")
	String address;
	@ApiModelProperty(notes = "The phone number of the user")
	String phoneNumber;
	@ApiModelProperty(notes = "The password of the user")
	@JsonIgnore
	String password;
	
	public User() {}
	
	public User(String id, String name, String address, String phoneNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
