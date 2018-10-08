package com.sar.rs;

import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class DAO
{
	

private static final String JNDIURL = "java:comp/env/jdbc/OCB";
private static Logger logger = Logger.getLogger("DAO.class");
		
public static Connection getConnection() throws Exception
{
	
	Connection con = null;
	
	try
	{		
         InitialContext ctx = new InitialContext();
         DataSource dataSource = (DataSource) ctx.lookup(JNDIURL);
		if ( dataSource == null )
		{
			   throw new Exception("Data source not found!");
			}

		con =  dataSource.getConnection();
	}
		
	catch(NamingException e)
	{
		
		logger.error("************************* NamingException in getJNDIConnection() " +e.getMessage());
	}
	catch(SQLException e)
	{
		
		logger.error("************************* SQLException in getJNDIConnection() " +e.getMessage());
	}
	return con;
	
	
}
  


public static void closeConnection(Connection con)
{
	if(con != null)
	
	try
	 {
		 con.close();	
	 }
	
	catch(SQLException e)
	{
		logger.error("************************* sqlException in closeConnection" +e.getMessage());
	}
}

}
	