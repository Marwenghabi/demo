package com.example.demo.dto;

public class RandomPhoneNumberResponse {
    private String message;
    private RandomPhoneNumber data;
    
    
    

    public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public RandomPhoneNumber getData() {
		return data;
	}




	public void setData(RandomPhoneNumber data) {
		this.data = data;
	}




	public RandomPhoneNumberResponse(String message, RandomPhoneNumber data) {
        this.message = message;
        this.data = data;
    }




	public RandomPhoneNumberResponse(String message2, Object data2) {
		// TODO Auto-generated constructor stub
	}
	
	

    // Getters and setters
}


