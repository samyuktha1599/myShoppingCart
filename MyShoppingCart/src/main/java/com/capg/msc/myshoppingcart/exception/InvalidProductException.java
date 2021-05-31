package com.capg.msc.myshoppingcart.exception;

public class InvalidProductException extends Exception{
	
	private String category;
	private int cost;
	
	public InvalidProductException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InvalidProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidProductException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidProductException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidProductException(String category, int cost) {
		super();
		this.category = category;
		this.cost = cost;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
