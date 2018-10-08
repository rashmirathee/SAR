package com.sar.rs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class StoreDAO
{
	
	
	
	public static List<Product> getProductsToOrder(int storeid)
{
	
	Session sess = HibernateDAO.getSession();

	
	 sess.beginTransaction();
	 	 
	 ArrayList<Product> Products = new ArrayList<Product>();
		
	  Query queryResult = sess.createQuery("from SkuStoreHib s where s.store_id = :storenum");
	  java.util.List<SkuStoreHib> allskus;
	  
	  queryResult.setParameter("storenum", storeid);
	  allskus = queryResult.getResultList();
	  for (int i = 0; i < allskus.size(); i++) 
	  {
	   SkuStoreHib sku = (SkuStoreHib) allskus.get(i);
	  
	   Query query = sess.createQuery("from Sku sk where sk.sku_number = :skunum");
	   query.setParameter("skunum", sku.getSku_id());
	    Sku s = (Sku)query.getSingleResult();
	  
	   Query q = sess.createQuery("from ProductParameters pp where pp.sku_number = :skunum");
	   q.setParameter("skunum", sku.getSku_id());
	   ProductParameters p =  (ProductParameters)q.getSingleResult();
	   
	   
		Product product = new Product();
		product.setSku_number(sku.getSku_id());
		product.setSku_desc(s.getSku_desc());
		product.setIs_approved(0);
		
		  
		
		if (sku.getIn_str_qty() + sku.getShelf_qty() < p.getSku_recmd_thrd())
		 {
  		    
  		  
				 			    
  		    product.setOrdr_qty(calculateunits_to_order( p.getTrk_dlvr_factor(),new Integer(sku.getSku_velocity()).intValue(),p.getVendr_min(),p.getPack_size()));
		}
   	
   		else
   		 {
   			 
   			 product.setOrdr_qty(new Integer(p.getSku_recmd_thrd()).intValue());
   		 }
   		 
		 Products.add(product);
	  }
   	    
   	 return Products;   
   }

	  private static int calculateunits_to_order(int a, int b, int c, int d)
	  {
	  	
	  	int  numberofunits = a * b;
	  		
	  		if(numberofunits <= c )
	  		{
	  			numberofunits = c;
	  		}
	  		 
	  			if(numberofunits % d != 0)
	  			{
	  			int e = numberofunits / d ;
	  			numberofunits = (e+1) * d;
	  			}
	  			
	  	return numberofunits;
	  }	
	   
	  public static void createPurchaseOrder(List<Product> p)
	  {
		  Session session = HibernateDAO.getSession();
		  Transaction tx = session.beginTransaction();

		 for(Product pr : p )
			 {
			 
			 System.out.println("***************** sku: " +pr.getSku_number() + "quantity : " + pr.getOrdr_qty());
		   	   
			 session.save(pr);
				 
			 }
			 
		 updatePurchaseOrder();
	      tx.commit();
	  }
	  
	  public static String getPurchaseOrder()
	  {
		  Session sess = HibernateDAO.getSession();

			
			 sess.beginTransaction();
			 
			 
			 Query query = sess.createQuery("from PurchaseOrder " );
			 PurchaseOrder po = (PurchaseOrder)query.getSingleResult();
			 int ponum =  po.getPo_num() + 1;
			
			return new Integer(ponum).toString();
	  }
	  
	  public static void updatePurchaseOrder()
	  {
	  
		  Session sess = HibernateDAO.getSession();

			
			 sess.beginTransaction();
			 
	   Query q = sess.createQuery("update PurchaseOrder set po_num = :po_num" );
		q.setParameter("po_num", new Integer(getPurchaseOrder()).intValue() + 1);
		int result = q.executeUpdate();
	  }
		  
	  }

	