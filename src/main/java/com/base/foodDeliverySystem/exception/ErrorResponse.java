package com.base.foodDeliverySystem.exception;

public class ErrorResponse {

	private  String message;
	private String status;
	public ErrorResponse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", status=" + status + "]";
	}
	
	
}
