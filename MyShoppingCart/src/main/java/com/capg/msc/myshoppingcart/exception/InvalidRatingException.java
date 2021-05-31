package com.capg.msc.myshoppingcart.exception;

public class InvalidRatingException extends Exception {
	
	private int rating;

	public InvalidRatingException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidRatingException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidRatingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidRatingException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidRatingException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidRatingException(int rating) {
		super();
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
