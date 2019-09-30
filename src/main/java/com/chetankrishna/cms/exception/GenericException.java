package com.chetankrishna.cms.exception;

public class GenericException {

	private String exceptionMessage;
	private String exceptionResponseCode;
	private String exceptionDateTime;
	
	public GenericException() {
		super();
	}
	
	public GenericException(String exceptionMessage, String exceptionResponseCode, String exceptionDateTime) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.exceptionResponseCode = exceptionResponseCode;
		this.exceptionDateTime = exceptionDateTime;
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getExceptionResponseCode() {
		return exceptionResponseCode;
	}
	
	public void setExceptionResponseCode(String exceptionResponseCode) {
		this.exceptionResponseCode = exceptionResponseCode;
	}
	
	public String getExceptionDateTime() {
		return exceptionDateTime;
	}
	
	public void setExceptionDateTime(String exceptionDateTime) {
		this.exceptionDateTime = exceptionDateTime;
	}
	
	@Override
	public String toString() {
		return "GenericException [exceptionMessage=" + exceptionMessage + ", exceptionResponseCode="
				+ exceptionResponseCode + ", exceptionDateTime=" + exceptionDateTime + "]";
	}
}
