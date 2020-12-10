package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
	public final CustomerRepository customerRepository;
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	public void registerCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	public Customer findByUsernameAndPassword(String username,String password) {
		return customerRepository.findByUsernameAndPassword(username, password);
	}
	public Customer findByUsername(String username) {
		return customerRepository.findByUsername(username);
	}

}
