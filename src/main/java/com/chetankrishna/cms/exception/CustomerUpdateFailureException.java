package com.chetankrishna.cms.exception;

public class CustomerUpdateFailureException extends RuntimeException {

	private static final long serialVersionUID = -8209370669220245908L;

	public CustomerUpdateFailureException(String message) {
		super(message);
	}
}
