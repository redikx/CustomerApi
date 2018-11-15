package org.redik.CustomerApi.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.CustomerApi.dao.CustomerDAO;
import org.redik.CustomerApi.entity.Customer;
import org.redik.CustomerApi.entity.Customer_card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public List<Customer> getCustomers() {
	return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
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

    @Transactional
    public void SaveCustomerWithCard(Customer theCustomer, Customer_card customer_card) {
	Session session = sessionFactory.getCurrentSession();
	session.persist(customer_card);
	session.persist(theCustomer);
    }
    
 
}
