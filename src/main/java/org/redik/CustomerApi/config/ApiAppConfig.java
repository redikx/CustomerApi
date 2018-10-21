package org.redik.CustomerApi.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("org.redik.CustomerApi")
@PropertySource("classpath:mysql.properties")
public class ApiAppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());
    
    
    // Define DataSource Bean
    @Bean
    public DataSource dataSource() {
	
	//create connection pool
	ComboPooledDataSource myDataSource = new ComboPooledDataSource();
	
	//set jdbc driver
	try {
	    myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
	    } 
	catch (PropertyVetoException exc) {
		    throw new RuntimeException(exc);
	}

	//set jdbc props
	myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	myDataSource.setUser(env.getProperty("jdbc.user"));
	myDataSource.setPassword("jdbc.password");
	logger.info("<<<<<<<< JDBC DRIVER : " + env.getProperty("jdbc.driver"));
		logger.info("<<<<<<<< JDBC URL : " + env.getProperty("jdbc.url"));
		logger.info("<<<<<<<< JDBC USER : " + env.getProperty("jdbc.user"));
		logger.info("<<<<<<<< JDBC PASSWORD : " + env.getProperty("jdbc.password"));
	//set pool props
	myDataSource.setInitialPoolSize(propIntoInteger("connection.pool.InitialPoolSize"));
	myDataSource.setMinPoolSize(propIntoInteger("connection.pool.MinPoolSize"));
	myDataSource.setMaxPoolSize(propIntoInteger("connection.pool.MinPoolSize"));
	
	return myDataSource;
    }
    
    // Hibernate properties
    private Properties HibernateProperties() {
	Properties props = new Properties();
	props.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
	props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	return props;
    }
    
    @Bean
    //define SessionFactory
    public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	sessionFactory.setDataSource(dataSource());
	sessionFactory.setHibernateProperties(HibernateProperties());
	sessionFactory.setPackagesToScan("org.redik.CustomerApi.entity");
	return sessionFactory;
	
    }
    
    // method to convert String property into Int
    public int propIntoInteger(String propName) {
	String propValue = env.getProperty("propName");
	int intProp = Integer.parseInt(propValue);
	return intProp;
    }

    @Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	 
    
}
