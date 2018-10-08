package com.sar.rs;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDAO
{
	private static Configuration cfg = new Configuration();
	
	public static Session getSession()
	{
	cfg.configure("hibernate.cfg.xml");
	System.out.println("Hibernate Configuration loaded");
	
	
	SessionFactory sessionFactory = cfg.buildSessionFactory();
	Session session =   sessionFactory.openSession();
	
	return session;
	}
	
	
}