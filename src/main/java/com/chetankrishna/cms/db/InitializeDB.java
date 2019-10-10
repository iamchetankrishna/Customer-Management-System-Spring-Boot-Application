package com.chetankrishna.cms.db;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chetankrishna.cms.model.Address;
import com.chetankrishna.cms.model.Customer;
import com.chetankrishna.cms.repository.CustomerRepository;

@Component
public class InitializeDB {
	
	private HashMap<Integer, Customer> customerDetailsMap;
	private static Integer customerCount = 0;
	
	@SuppressWarnings("unused")
	private CustomerRepository customerRepository;
	
	private InitializeDB(@Autowired CustomerRepository customerRepository) {
		
		this.customerRepository = customerRepository;
		
		Address addressOne = new Address(1,"777", "Ground Floor", "XYZ Road", "New Delhi", "Delhi",
				"India", "IN", "110001");
		Address addressTwo = new Address(2,"888", "First Floor", "ABC Road", "New Delhi", "Delhi",
				"India", "IN", "110002");
		
		Customer customerOne = new Customer(++customerCount, "John Doe", addressOne, "8888888888", "M");
		Customer customerTwo = new Customer(++customerCount, "Johanna Joe", addressTwo, "9999999999", "F");
		Customer customerThree = new Customer(++customerCount, "Smacky Joe", addressOne, "1111111111", "M");
		Customer customerFour = new Customer(++customerCount, "Ema Joe", addressTwo, "2222222222", "F");
		Customer customerFive = new Customer(++customerCount, "Rosie", addressOne, "3333333333", "F");
		Customer customerSix = new Customer(++customerCount, "Chandler Bing", addressTwo, "4444444444", "M");
		Customer customerSeven = new Customer(++customerCount, "Rachel", addressOne, "5555555555", "F");
		Customer customerEight = new Customer(++customerCount, "Joey", addressTwo, "6666666666", "M");
		Customer customerNine = new Customer(++customerCount, "Martha Wayne", addressOne, "7777777777", "F");
		Customer customerTen = new Customer(++customerCount, "Thomas Wayne", addressTwo, "0000000000", "M");
		
		customerDetailsMap = new HashMap<>();
		customerDetailsMap.put(customerOne.getCustomerId(), customerOne);
		customerDetailsMap.put(customerTwo.getCustomerId(), customerTwo);
		customerDetailsMap.put(customerThree.getCustomerId(), customerThree);
		customerDetailsMap.put(customerFour.getCustomerId(), customerFour);
		customerDetailsMap.put(customerFive.getCustomerId(), customerFive);
		customerDetailsMap.put(customerSix.getCustomerId(), customerSix);
		customerDetailsMap.put(customerSeven.getCustomerId(), customerSeven);
		customerDetailsMap.put(customerEight.getCustomerId(), customerEight);
		customerDetailsMap.put(customerNine.getCustomerId(), customerNine);
		customerDetailsMap.put(customerTen.getCustomerId(), customerTen);
		
		customerDetailsMap.values().stream().forEach(customer -> customerRepository.save(customer));
	}

	public HashMap<Integer, Customer> getCustomerDetailsMap() {
		return customerDetailsMap;
	}

	public static Integer getCustomerCount() {
		return customerCount;
	}

}
