package org.redik.CustomerApi.RestController;

import java.util.List;

import org.redik.CustomerApi.entity.Customer;
import org.redik.CustomerApi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestControllerCustomers {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public List<Customer> RestGetCustomers() {
	return customerService.getCustomers();
    }
    
    @GetMapping("/customers/{customerId}")
    public Customer RestGetCustomer(@PathVariable int customerId) {
	Customer theCustomer = customerService.getCustomer(customerId);
	
	if ( theCustomer == null) {
	    throw new CustomerNotFoundException("Customer hasn't found");
	}
	
	return theCustomer;
    }
    
@PostMapping("/customers")
public Customer RestAddCustomer(@RequestBody Customer customer) {
    customer.setId(0);
    customerService.SaveCustomer(customer);
    return customer;
}
    }

