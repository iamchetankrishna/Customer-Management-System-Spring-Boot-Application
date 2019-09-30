package com.chetankrishna.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.chetankrishna.cms.exception.CustomerCreationFailureException;
import com.chetankrishna.cms.exception.CustomerNotFoundException;
import com.chetankrishna.cms.exception.CustomerUpdateFailureException;
import com.chetankrishna.cms.exception.NoCustomerFoundException;
import com.chetankrishna.cms.model.Address;
import com.chetankrishna.cms.model.Customer;

@Service
public class CustomerService {

	private HashMap<Integer, Customer> customerDetailsMap;
	private static Integer customerCount = 0;
	
	private CustomerService() {
		
		Address addressOne = new Address("777", "Ground Floor", "XYZ Road", "New Delhi", "Delhi",
				"India", "IN", "110001");
		Customer customerOne = new Customer(++customerCount, "John Doe", addressOne, "8888888888", "M");
		Customer customerTwo = new Customer(++customerCount, "Smacky Joe", addressOne, "9999999999", "M");
		
		customerDetailsMap = new HashMap<>();
		customerDetailsMap.put(customerOne.getCustomerId(), customerOne);
		customerDetailsMap.put(customerTwo.getCustomerId(), customerTwo);
	}
	
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
		if(customerDetailsMap.containsKey(customerId)) {
			return customerDetailsMap.get(customerId);
		}
		else {
			throw new CustomerNotFoundException("Customer with Id : " + customerId + " not found !");
		}
	}
	
	public List<Customer> getAllCustomer() throws NoCustomerFoundException {
		if(!customerDetailsMap.isEmpty()) {
			return customerDetailsMap.values().stream().collect(Collectors.toList());
		}
		else {
			throw new NoCustomerFoundException("Database is empty. No Customer Exists !");
		}
	}
	
	public Customer addCustomer(Customer customer) throws CustomerCreationFailureException {
		if(validateCustomer(customer)) {
			customer.setCustomerId(++customerCount);
			customerDetailsMap.put(customer.getCustomerId(), customer);
			return customer;
		}
		else {
			throw new CustomerCreationFailureException("Unable to create customer because of invalid input !!");
		}
	}
	
	public Customer updateCustomer(Customer customer) throws CustomerUpdateFailureException, CustomerNotFoundException {
		if(customerDetailsMap.containsKey(customer.getCustomerId())) {
			if(validateCustomer(customer)) {
				customerDetailsMap.replace(customer.getCustomerId(), customer);
				return customer;
			}
			else {
				throw new CustomerUpdateFailureException("Unable to create customer because of invalid input !!");
			}
		}
		else {
			throw new CustomerNotFoundException("No Such Customer exists with Id : " + customer.getCustomerId());
		}
	}
	
	public void deleteCustomer(Integer customerId) throws CustomerNotFoundException {
		if(customerDetailsMap.containsKey(customerId)) {
			customerDetailsMap.remove(customerId);
		}
		else {
			throw new CustomerNotFoundException("No Such Customer exists with Id : " + customerId);
		}
	}
	
	private boolean validateCustomer(Customer customer) {
		if(customer.getCustomerSex().equals("M") || customer.getCustomerSex().equals("F")) 
			return true;
		else
			return false;
	}
	
}
