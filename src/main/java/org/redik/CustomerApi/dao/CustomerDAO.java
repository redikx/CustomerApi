package org.redik.CustomerApi.dao;

import java.util.List;

import org.redik.CustomerApi.entity.Customer;
import org.redik.CustomerApi.entity.Customer_card;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO {

    public List<Customer> getCustomers();
    
    public Customer getCustomer(int theId);
    
    public void SaveCustomer(Customer theCustomer);
    
    public void DeleteCustomer(int thrId);

}
