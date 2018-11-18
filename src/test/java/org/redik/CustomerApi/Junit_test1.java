package org.redik.CustomerApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redik.CustomerApi.config.ApiAppConfig;
import org.redik.CustomerApi.entity.Customer;
import org.redik.CustomerApi.entity.Customer_card;
import org.redik.CustomerApi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("org.redik.CustomerApi")
@WebAppConfiguration
@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApiAppConfig.class})
@Transactional

public class Junit_test1 {
    
    @Autowired
    CustomerService customerService;
    
  /*  @Test
    public void chk_row_returned() {
	Customer cust = customerService.getCustomer(1);
	System.out.println(cust.toString());
    }*/
    
    @Test
    @Rollback(false)
    public void chk_row_insert() {
	Customer cust = new Customer("Zenon","Zajebiaszczak","zajeb@gmail.com");
	Customer_card card = new Customer_card("A00002",cust);
	cust.setCustomer_card(card);
	customerService.SaveCustomerWithCard(cust,card);
    }
    
    @Test
    public void testCrudRepository() {
	
    }

}
	