package com.chetankrishna.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetankrishna.cms.db.InitializeDB;
import com.chetankrishna.cms.exception.CustomerCreationFailureException;
import com.chetankrishna.cms.exception.CustomerNotFoundException;
import com.chetankrishna.cms.exception.CustomerUpdateFailureException;
import com.chetankrishna.cms.exception.NoCustomerFoundException;
import com.chetankrishna.cms.interfaces.CustomerService;
import com.chetankrishna.cms.model.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService{
	
	private HashMap<Integer, Customer> customerDetailsMap;
	private static Integer customerCount = 0;
	
	@SuppressWarnings("unused")
	private InitializeDB initializeDB;
	
	@SuppressWarnings("static-access")
	private CustomerServiceImplementation(@Autowired InitializeDB initializeDB) {
		this.initializeDB = initializeDB;
		this.customerDetailsMap = initializeDB.getCustomerDetailsMap();
		customerCount = initializeDB.getCustomerCount();
	}
	
	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
		if(customerDetailsMap.containsKey(customerId)) {
			return customerDetailsMap.get(customerId);
		}
		else {
			throw new CustomerNotFoundException("Customer with Id : " + customerId + " not found !");
		}
	}
	
	@Override
	public List<Customer> getAllCustomer() throws NoCustomerFoundException {
		if(!customerDetailsMap.isEmpty()) {
			return customerDetailsMap.values().stream().collect(Collectors.toList());
		}
		else {
			throw new NoCustomerFoundException("Database is empty. No Customer Exists !");
		}
	}
	
	@Override
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
	
	@Override
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
	
	@Override
	public void deleteCustomer(Integer customerId) throws CustomerNotFoundException {
		if(customerDetailsMap.containsKey(customerId)) {
			customerDetailsMap.remove(customerId);
		}
		else {
			throw new CustomerNotFoundException("No Such Customer exists with Id : " + customerId);
		}
	}	
}
