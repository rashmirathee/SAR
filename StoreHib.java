package com.sar.rs;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





public class StoreHib implements java.io.Serializable
{
	
		
	private static final long serialVersionUID = 1L;


		private int store_number;
	
	
	public int getStore_number() {
			return store_number;
		}




		public void setStore_number(int store_number) {
			this.store_number = store_number;
		}




		public String getStore_name() {
			return store_name;
		}




		public void setStore_name(String store_name) {
			this.store_name = store_name;
		}




		public String getStore_location() {
			return store_location;
		}




		public void setStore_location(String store_location) {
			this.store_location = store_location;
		}




		public String getStore_city() {
			return store_city;
		}




		public void setStore_city(String store_city) {
			this.store_city = store_city;
		}




		public int getPostal_code() {
			return postal_code;
		}




		public void setPostal_code(int postal_code) {
			this.postal_code = postal_code;
		}




		public String getStore_market() {
			return store_market;
		}




		public void setStore_market(String store_market) {
			this.store_market = store_market;
		}




		public static long getSerialversionuid() {
			return serialVersionUID;
		}




	private String store_name;
	
	
	private String store_location;
	
	
	private String store_city;
	
	
	private int postal_code;
	
	
	private String store_market;
	
	
	
	public StoreHib()
	{
		
	}
	
	
	
	
	public StoreHib(int str_number, String str_name, String str_location, String str_city,
			int zip_code, String str_market) {
		
		
		this.store_number = str_number;
		this.store_name = str_name;
		this.store_location = str_location;
		this.store_city = str_city;
		this.postal_code = zip_code;
		this.store_market = str_market;
	}


	
	
}