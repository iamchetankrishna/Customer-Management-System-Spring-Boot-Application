package com.chetankrishna.cms.exception;

public class CustomerCreationFailureException extends RuntimeException{

	private static final long serialVersionUID = 3846403740690319063L;

	public CustomerCreationFailureException(String message) {
		super(message);
	}
}
