package com.chetankrishna.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetankrishna.cms.db.InitializeDB;
import com.chetankrishna.cms.exception.CustomerCreationFailureException;
import com.chetankrishna.cms.exception.CustomerNotFoundException;
import com.chetankrishna.cms.exception.CustomerUpdateFailureException;
import com.chetankrishna.cms.exception.NoCustomerFoundException;
import com.chetankrishna.cms.interfaces.CustomerService;
import com.chetankrishna.cms.model.Customer;
import com.chetankrishna.cms.repository.CustomerRepository;

@Service
public class CustomerServiceDAOImplementation implements CustomerService {

	private CustomerRepository customerRepository;
	private InitializeDB initializeDB;
	
	
	private CustomerServiceDAOImplementation(@Autowired CustomerRepository customerRepository, @Autowired InitializeDB initializeDB) {
		this.customerRepository = customerRepository;
		this.initializeDB = initializeDB;
	}
	
	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
		Optional<Customer> customerOptional = checkCustomerExistsCrudRepository(customerRepository, customerId);
		if(customerOptional.isPresent()) {
			return customerOptional.get();
		}else {
			throw new CustomerNotFoundException("Customer with Id : " + customerId + " not found !");
		}
	}

	@Override
	public List<Customer> getAllCustomer() throws NoCustomerFoundException {
		Iterable<Customer> customerIterable = customerRepository.findAll();
		List<Customer> customerList;
		if(customerRepository.count() > 0) {
			customerList = new ArrayList<>();
			customerIterable.forEach(customer -> customerList.add(customer));
			return customerList;
		}else {
			throw new NoCustomerFoundException("Database is empty. No Customer Exists !");
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public Customer addCustomer(Customer customer) throws CustomerCreationFailureException {
		if(validateCustomer(customer)) {
			customer.setCustomerId(initializeDB.getCustomerCount() + 1);
			customerRepository.save(customer);
			return customer;
		}else {
			throw new CustomerCreationFailureException("Unable to create customer because of invalid input !!");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerUpdateFailureException, CustomerNotFoundException {
		if(checkCustomerExistsCrudRepository(customerRepository, customer.getCustomerId()).isPresent()) {
			if(validateCustomer(customer)) {
				customerRepository.save(customer);
				return customer;
			}else {
				throw new CustomerUpdateFailureException("Unable to create customer because of invalid input !!");
			}
		}else {
			throw new CustomerNotFoundException("No Such Customer exists with Id : " + customer.getCustomerId());
		}
	}

	@Override
	public void deleteCustomer(Integer customerId) throws CustomerNotFoundException {
		if(checkCustomerExistsCrudRepository(customerRepository, customerId).isPresent()) {
			customerRepository.deleteById(customerId);
		}else {
			throw new CustomerNotFoundException("No Such Customer exists with Id : " + customerId);
		}
	}

}
