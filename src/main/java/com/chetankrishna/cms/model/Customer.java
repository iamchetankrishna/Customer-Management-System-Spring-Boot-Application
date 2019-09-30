package com.chetankrishna.cms.model;

public class Customer {
	
	private Integer customerId;
	private String customerName;
	private Address customerAddress;
	private String customerSex;
	private String customerContactNumber;
	
	public Customer() {
		super();
	}

	public Customer(Integer customerId, String customerName, Address customerAddress,
			String customerContactNumber, String customerSex) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerContactNumber = customerContactNumber;
		this.customerSex = customerSex;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerContactNumber() {
		return customerContactNumber;
	}

	public void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerSex=" + customerSex + ", customerContactNumber=" + customerContactNumber
				+ "]";
	}
}
