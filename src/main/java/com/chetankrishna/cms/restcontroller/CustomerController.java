package com.chetankrishna.cms.restcontroller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
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
import com.chetankrishna.cms.service.CustomerServiceImplementation;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	private CustomerServiceImplementation customerServiceImplementation;
	
	private CustomerController(@Autowired CustomerServiceImplementation customerServiceImplementation) {
		this.customerServiceImplementation = customerServiceImplementation;
	}
	
	@GetMapping(value = "/all") 
	public ResponseEntity<?> getAllCustomer() {
		List<Customer> customerList = customerServiceImplementation.getAllCustomer();
		List<Resource<Customer>> customerResourceList = new ArrayList<>();
		for(Customer customer : customerList) {
			Link customerLink = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
			Resource<Customer> customerResource = new Resource<>(customer, customerLink);
			customerResourceList.add(customerResource);
		}
		Link link = linkTo(CustomerController.class).withSelfRel();
		Resources<Resource<Customer>> customerResources = new Resources<>(customerResourceList, link);
		return new ResponseEntity<Resources<Resource<Customer>>>(customerResources, null, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") Integer customerId) {
		Customer customer = customerServiceImplementation.getCustomerById(customerId);
		Link customerLink = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
		Resource<Customer> customerResource = new Resource<>(customer, customerLink);
		return new ResponseEntity<Resource<Customer>>(customerResource, null, HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customerRequest) {
		Customer customer = customerServiceImplementation.addCustomer(customerRequest);
		Link customerLink = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
		Resource<Customer> customerResource = new Resource<>(customer, customerLink);
		return new ResponseEntity<Resource<Customer>>(customerResource, null, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{customerId}")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customerRequest) {
		Customer customer = customerServiceImplementation.updateCustomer(customerRequest);
		Link customerLink = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
		Resource<Customer> customerResource = new Resource<>(customer, customerLink);
		return new ResponseEntity<Resource<Customer>>(customerResource, null, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Integer customerId) {
		customerServiceImplementation.deleteCustomer(customerId);
		return new ResponseEntity<>(null, null, HttpStatus.OK);
	}
}
