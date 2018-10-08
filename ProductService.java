package com.sar.rs;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.Logger;




@Path("/products")

public class ProductService
{
 
	private static Logger logger = Logger.getLogger("ProductService.class");
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/replenish")
	public String getReplenishOrder(@QueryParam("store_id") String storeid)
	{ 					
		 List<Product> Products = new ArrayList<Product>();
		 String list = "";
		 
		if(!("store_id".equals(null)  && "store_id".length() > 0))
		{
			
		try 
		{
			
			Products = StoreDAO.getProductsToOrder(Integer.parseInt(storeid));
		} 
		catch (NumberFormatException e)
		{
			logger.error("**** NumberFormatException in getReplenishOrder in ProductService.class " + e.getMessage());
		} 
		catch (Exception e) 
		{
			logger.error("**** NumberFormatException in getReplenishOrder in ProductService.class " + e.getMessage());
		}
		
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		
		try
		{
			
			list = objectMapper.writeValueAsString(Products);
			
		} 
		catch (JsonGenerationException e) 
		{
			logger.error("**** JsonGenerationException in getReplenishOrder in ProductService.class " + e.getMessage());
		} 
		catch (JsonMappingException e)
		{
			logger.error("**** JsonMappingException in getReplenishOrder in ProductService.class  " + e.getMessage());
		} 
		catch (IOException e) 
		{
			logger.error("**** IOException in getReplenishOrder in ProductService.class " + e.getMessage());
		}
		
  
		
		return list;
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/updateOrder")
	public void updateOrder(@QueryParam("store_id") String store_id , String pl)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		List<Product> Products = new ArrayList<Product>();
		
		
		
	try 
		{
			JsonNode rootArray = objectMapper.readTree(pl);
			for(JsonNode root : rootArray)
			{
			   String sku_id = root.path("sku_number").asText();
			   String sku_desc = root.path("sku_desc").asText();
			   String units_to_order = root.path("units_to_order").asText();
			   JsonNode new_units_to_order_node = root.path("new_units_to_order");
			  
				if(sku_id != null && sku_id.length() > 0)
				{
			   
			   if (new_units_to_order_node.isMissingNode())
				{
					
					Product product = new Product( StoreDAO.getPurchaseOrder(),new Integer(sku_id).intValue(),new Integer(store_id).intValue(),new Integer(units_to_order).intValue(),0);
					Products.add(product);
					
				} 
			   
			   else
			   {
				   String new_units_to_order = root.path("new_units_to_order").asText();
			  
				  
				  double diff = Integer.parseInt(new_units_to_order) - Integer.parseInt(units_to_order);
				  
				  double tenpercent = 0.1 * Integer.parseInt(units_to_order);
				  
				  if( diff >= tenpercent)
				  {
					  
					 PurchaseOrderMessage purchaseorder = new PurchaseOrderMessage();
					 purchaseorder.sendPurchaseOrderMessage("Store Number: " + store_id + "SKU Number: " + sku_id + ", Recommended Units to Order: " + units_to_order
							 +", Units Ordered: " + new_units_to_order);
					 		
			      }
			   	
			   else
			   {				   
				     Product product = new Product(StoreDAO.getPurchaseOrder(),new Integer(sku_id).intValue(),new Integer(store_id).intValue(),new Integer(new_units_to_order).intValue(),0);
					 Products.add(product);
				
			   }
			   }
			}
			}
		} 
		catch (JsonProcessingException e) 
		{
			logger.error("**** JsonProcessingException in updateOrder in ProductService.class  " + e.getMessage());
		} 
		catch (IOException e)
		{
			logger.error("**** IOException in updateOrder in ProductService.class  " + e.getMessage());
		}

	try
	{
		StoreDAO.createPurchaseOrder(Products);
	}
	catch(Exception e )
	{
		logger.error("**** Exception in updateOrder in ProductService.class  " + e.getMessage());
	}
		
		
	}		
	
	
}


