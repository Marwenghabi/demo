package com.example.demo.dto;

public class RandomPhoneNumber {
	private String type;
	private String phoneNumber;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public RandomPhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RandomPhoneNumber(String type, String phoneNumber) {
		super();
		this.type = type;
		this.phoneNumber = phoneNumber;
	}

}
