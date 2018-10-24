package org.redik.CustomerApi.service;

import java.util.List;

import org.redik.CustomerApi.entity.Customer;
import org.springframework.context.annotation.Bean;


public interface CustomerService {

    public List<Customer> getCustomers();
    
    public Customer getCustomer(int theId);
    
    public void deleteCustomer(int theId);
    
    public void SaveCustomer(Customer theCustomer);
}
