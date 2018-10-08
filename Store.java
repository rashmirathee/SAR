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



@Entity
@Table(name="store")


public class Store 
{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STR_NUMBER")
	private int store_number;
	
	@Column(name = "STR_NAME")
	private String store_name;
	
	@Column(name = "STR_LOCATION")
	private String store_location;
	
	@Column(name = "STR_CITY")
	private String store_city;
	
	@Column(name = "ZIP_CODE")
	private int postal_code;
	
	@Column(name = "STR_MARKET")
	private String store_market;
	
	
	public int getStr_number() {
		return store_number;
	}
	public void setStr_number(int store_number) {
		this.store_number = store_number;
	}
	
	
	

	
	
	

	public String getStr_name() {
		return store_name;
	}
	public void setStr_name(String store_name) {
		this.store_name = store_name;
	}
	
	
	public String getStr_location() {
		return store_location;
	}
	public void setStr_location(String store_location) {
		this.store_location = store_location;
	}
	
	
	public String getStr_city() {
		return store_city;
	}
	public void setStr_city(String store_city) {
		this.store_city = store_city;
	}
	
	
	public int getZip_code() {
		return postal_code;
	}
	public void setZip_code(int postal_code) {
		this.postal_code = postal_code;
	}
	
	
	public String getStr_market() {
		return store_market;
	}
	public void setStr_market(String store_market) {
		this.store_market = store_market;
	}
	
	public Store()
	{
		
	}
	
	
	
	
	public Store(int str_number, String str_name, String str_location, String str_city,
			int zip_code, String str_market) {
		
		
		this.store_number = str_number;
		this.store_name = str_name;
		this.store_location = str_location;
		this.store_city = str_city;
		this.postal_code = zip_code;
		this.store_market = str_market;
	}


	
	
}