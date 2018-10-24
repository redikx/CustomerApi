package org.redik.CustomerApi.service;

import java.util.List;

import org.redik.CustomerApi.dao.CustomerDAO;
import org.redik.CustomerApi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    
    @Override
    @Transactional
    public List<Customer> getCustomers() {
	return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCoustomer(int theId) {
	return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
	customerDAO.DeleteCustomer(theId);
    }

    @Override
    public void SaveCustomer(Customer theCustomer) {
	customerDAO.SaveCustomer(theCustomer);
    }

}
