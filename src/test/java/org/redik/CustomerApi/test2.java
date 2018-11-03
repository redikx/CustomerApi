package org.redik.CustomerApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redik.CustomerApi.config.ApiAppConfig;
import org.redik.CustomerApi.entity.Customer;
import org.redik.CustomerApi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.BaseMatcher.*;

@ComponentScan("org.redik.CustomerApi")
@WebAppConfiguration
@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApiAppConfig.class})

public class test2 {
    
    @Autowired
    CustomerService customerService;
    
    @Test
    public void test() {
	Customer cust = customerService.getCustomer(1);
	junit.framework.Assert.assertEquals("Mueller", cust.getLast_name());
    }

}
