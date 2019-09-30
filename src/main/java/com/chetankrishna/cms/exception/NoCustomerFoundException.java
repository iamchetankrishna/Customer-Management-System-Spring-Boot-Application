package com.chetankrishna.cms.exception;

public class NoCustomerFoundException extends RuntimeException{

	private static final long serialVersionUID = 4754079017238724420L;

	public NoCustomerFoundException(String message) {
		super(message);
	}
}
