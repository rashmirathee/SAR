package com.sar.rs;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sar_po")
@IdClass(PoKey.class)
public class Product
{
	
	@Id
	@Column(name = "PO_NUMBER")
	private String po_number;
	
	@Id
	@Column(name = "SKU_NUMBER")
	private int sku_number;
	
	@Id
	@Column(name = "STR_NUMBER")
	private int str_number;
	
	@Column(name = "ORDR_QTY")
    private int ordr_qty;
	
	@Column(name = "IS_APPROVED")
    private int is_approved;
	
	@Transient
	private String sku_desc;
	

	public String getSku_desc() {
		return sku_desc;
	}

	public void setSku_desc(String sku_desc) {
		this.sku_desc = sku_desc;
	}

	public Product()
	{
		
	}

	public Product(String po_number, int sku_number, int str_number, int ordr_qty, int is_approved) {
		this.po_number = po_number;
		this.sku_number = sku_number;
		this.str_number = str_number;
		this.ordr_qty = ordr_qty;
		this.is_approved = is_approved;
	}

	public String getPo_number() {
		return po_number;
	}

	public void setPo_number(String po_number) {
		this.po_number = po_number;
	}

	public int getSku_number() {
		return sku_number;
	}

	public void setSku_number(int sku_number) {
		this.sku_number = sku_number;
	}

	public int getStr_number() {
		return str_number;
	}

	public void setStr_number(int str_number) {
		this.str_number = str_number;
	}

	public int getOrdr_qty() {
		return ordr_qty;
	}

	public void setOrdr_qty(int ordr_qty) {
		this.ordr_qty = ordr_qty;
	}

	public int getIs_approved() {
		return is_approved;
	}

	public void setIs_approved(int is_approved) {
		this.is_approved = is_approved;
	}
	
}