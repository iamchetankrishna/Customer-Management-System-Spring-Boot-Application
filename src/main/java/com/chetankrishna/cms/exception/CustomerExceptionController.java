package com.chetankrishna.cms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionController {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<GenericException> customerNotFoundException(CustomerNotFoundException customerNotFoundException) {
		GenericException genericException = new GenericException(customerNotFoundException.getMessage(), 
						HttpStatus.NOT_FOUND.toString(), LocalDateTime.now().toString());
		return new ResponseEntity<>(genericException, null, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoCustomerFoundException.class)
	public ResponseEntity<GenericException> noCustomerdFoundExeption(NoCustomerFoundException noCustomerFoundException) {
		GenericException genericException = new GenericException(noCustomerFoundException.getMessage(), 
						HttpStatus.NOT_FOUND.toString(), LocalDateTime.now().toString());
		return new ResponseEntity<>(genericException, null, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CustomerCreationFailureException.class)
	public ResponseEntity<GenericException> customerCreationFailureException(CustomerCreationFailureException customerCreationFailureException) {
		GenericException genericException = new GenericException(customerCreationFailureException.getMessage(), 
						HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now().toString());
		return new ResponseEntity<>(genericException, null, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = CustomerUpdateFailureException.class)
	public ResponseEntity<GenericException> customerUpdateFailureException(CustomerUpdateFailureException customerUpdateFailureException) {
		GenericException genericException = new GenericException(customerUpdateFailureException.getMessage(), 
						HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now().toString());
		return new ResponseEntity<>(genericException, null, HttpStatus.BAD_REQUEST);
	}
}
