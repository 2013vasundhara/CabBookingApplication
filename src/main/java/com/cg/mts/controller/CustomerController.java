package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Customer;
import com.cg.mts.service.ICustomerService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

@Validated
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	

	@PostMapping("/login")
	public String userLogin( @RequestBody Customer customer) {
		
		return customerService.LoginUser(customer);
	}
	

	@PostMapping("/customers")
	public String insertCustomer( @RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}
	

	@PutMapping("/customers/{id}")
	public Customer updateCustomer( @RequestBody Customer customer, @PathVariable("id") Long id) {
		return customerService.updateCustomer(customer, id);
	}
	
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer( @PathVariable("id") Long id) {
		return customerService.deleteCustomer(id);
	}
	

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.viewCustomers();
	}
	

	@GetMapping("/customers/{id}")
	public Customer getCustomerById( @PathVariable("id") Long id) {
		return customerService.viewCustomer(id);
	}
	
}
