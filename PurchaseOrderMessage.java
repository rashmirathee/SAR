package com.sar.rs;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;



public class PurchaseOrderMessage
{
	private static Logger logger = Logger.getLogger("PurchaseOrderMessage.class");
	public PurchaseOrderMessage()
	{
		
	}
	
	public void sendPurchaseOrderMessage(String message)
	{
		
	try
	{
	
		Context ctx = new InitialContext();
		Context envcontext = (Context) ctx.lookup("java:comp/env");
		
		
		 ConnectionFactory cf = (ConnectionFactory) envcontext.lookup("jms/Connection");
	  
		 Connection connection = cf.createConnection();
		 connection.start();
	
	      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	      Message msg = session.createTextMessage(message);
	
	      Queue messagequeue = session.createQueue("PURCHASE_ORDER.QUEUE");
	
	      MessageProducer producer = session.createProducer(messagequeue);
	
	       producer.send(msg);
	
	       connection.close();
	}
	
	catch(JMSException e )
	{
		logger.error("**** JMSException in sendPurchaseOrderMessage in PurchaseOrderMessage.class " + e.getMessage());
		
	} catch (NamingException e)
	{
		logger.error("**** NamingException in sendPurchaseOrderMessage in PurchaseOrderMessage.class " + e.getMessage());
		
	}
	
	}
}
