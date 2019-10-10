package com.chetankrishna.cms.repository;

import org.springframework.data.repository.CrudRepository;

import com.chetankrishna.cms.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
