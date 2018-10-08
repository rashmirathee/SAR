package com.sar.rs;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="sku")

public class Sku
{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sku_number")
	
	private int sku_number;
	
	@Column(name = "SKU_DESC")
	private String sku_desc;
	
	@Column(name = "SKU_TYPE")
	private String sku_type;
	
	@Column(name = "SKU_DETAILS")
	private String sku_details;
	
	@Column(name = "SPCL_MARKET")
	private String sku_market;
	
	public int getSku_number() {
		return sku_number;
	}

	public void setSku_number(int sku_number) {
		this.sku_number = sku_number;
	}

	public String getSku_desc() {
		return sku_desc;
	}

	public void setSku_desc(String sku_desc) {
		this.sku_desc = sku_desc;
	}

	public String getSku_type() {
		return sku_type;
	}

	public void setSku_type(String sku_type) {
		this.sku_type = sku_type;
	}

	public String getSku_details() {
		return sku_details;
	}

	public void setSku_details(String sku_details) {
		this.sku_details = sku_details;
	}

	public String getSku_market() {
		return sku_market;
	}

	public void setSku_market(String sku_market) {
		this.sku_market = sku_market;
	}
 
	public Sku()
	{
		
	}
	
}
