package com.chetankrishna.cms.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2933010462445791847L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
