package com.chetankrishna.cms.interfaces;

import java.util.List;
import java.util.Optional;

import com.chetankrishna.cms.exception.CustomerCreationFailureException;
import com.chetankrishna.cms.exception.CustomerNotFoundException;
import com.chetankrishna.cms.exception.CustomerUpdateFailureException;
import com.chetankrishna.cms.exception.NoCustomerFoundException;
import com.chetankrishna.cms.model.Customer;
import com.chetankrishna.cms.repository.CustomerRepository;

public interface CustomerService {

	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException;
	public List<Customer> getAllCustomer() throws NoCustomerFoundException;
	public Customer addCustomer(Customer customer) throws CustomerCreationFailureException;
	public Customer updateCustomer(Customer customer) throws CustomerUpdateFailureException, CustomerNotFoundException;
	public void deleteCustomer(Integer customerId) throws CustomerNotFoundException;
	
	public default boolean validateCustomer(Customer customer) {
		if(customer.getCustomerSex().equals("M") || customer.getCustomerSex().equals("F")) 
			return true;
		else
			return false;
	}
	
	public default Optional<Customer> checkCustomerExistsCrudRepository(CustomerRepository customerRepository, Integer customerId) {
		return customerRepository.findById(customerId);
	}
}
