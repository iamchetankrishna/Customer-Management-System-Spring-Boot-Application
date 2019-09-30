package com.chetankrishna.cms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetankrishna.cms.model.Customer;
import com.chetankrishna.cms.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	private CustomerService customerService;
	
	private CustomerController(@Autowired CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(value = "/all") 
	public ResponseEntity<?> getAllCustomer() {
		List<Customer> customerList = customerService.getAllCustomer();
		return new ResponseEntity<List<Customer>>(customerList, null, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") Integer customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return new ResponseEntity<Customer>(customer, null, HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customerRequest) {
		Customer customer = customerService.addCustomer(customerRequest);
		return new ResponseEntity<Customer>(customer, null, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{customerId}")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customerRequest) {
		Customer customer = customerService.updateCustomer(customerRequest);
		return new ResponseEntity<Customer>(customer, null, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Integer customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>(null, null, HttpStatus.OK);
	}
}
