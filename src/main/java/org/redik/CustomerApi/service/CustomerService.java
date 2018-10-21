package org.redik.CustomerApi.service;

import java.util.List;

import org.redik.CustomerApi.entity.Customer;

public interface CustomerService {

    public List<Customer> getCustomers();
    
    public Customer getCoustomer(int theId);
    
    public void deleteCustomer(int theId);
    
    public void SaveCustomer(Customer theCustomer);
}
