package org.redik.CustomerApi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hello world!
 *
 */
public class App 
{

    @Autowired
    private DataSource dataSource;
	
    public static void main( String[] args )
    {

        System.out.println( "Hello World! : " );
        
    }
}
