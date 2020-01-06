package com.deloitte.ecommerce.exceptions;

public class InvalidCredentials extends RuntimeException{

	public InvalidCredentials(String msg) {
		super(msg);
	}

}
