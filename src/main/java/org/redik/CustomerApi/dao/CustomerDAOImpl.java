package org.redik.CustomerApi.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.redik.CustomerApi.entity.Customer;
import org.redik.CustomerApi.entity.Customer_card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Customer> getCustomers() {
	Session session = sessionFactory.getCurrentSession();
	TypedQuery<Customer> thisQuery = session.createQuery("from Customer order by id",Customer.class);
	List<Customer> customers = thisQuery.getResultList();
	return customers;
    }

    @Override
    public Customer getCustomer(int theId) {
	Session session = sessionFactory.getCurrentSession();
	Customer customer = session.get(Customer.class, theId);
	return customer;
    }
    
    @Transactional
    @Override
    public void SaveCustomer(Customer theCustomer) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(theCustomer);
    }
    
    @Transactional
    @Override
    public void DeleteCustomer(int thrId) {
	Session session = sessionFactory.getCurrentSession();
	Query theQuery = session.createQuery("delete from Customer where id = :idToDelete");
	theQuery.setParameter("idToDelete", thrId);
	theQuery.executeUpdate();
    }



}
