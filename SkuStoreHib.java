package com.sar.rs;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sku_store")
@IdClass(MyKey.class)

public class SkuStoreHib implements java.io.Serializable {

	
	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "SKU_NUMBER")

	private int sku_id;
	
	public int getSku_id() {
		return sku_id;
	}

	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
    
	@Id
	@Column(name = "STORE_NUM")

	private int store_id;
	
	
	@Column(name="TRK_DLVR_TIME_DAYS")
	private int trk_dlvr_time_days;
	
	@Column(name="IN_STR_QTY")
	private int in_str_qty;
	
	@Column(name="SHELF_QTY")
	private int shelf_qty;
	
	@Column(name="SKU_VELOCITY")
	private String sku_velocity;
	
	
	
	
	
	public String getSku_velocity() {
		return sku_velocity;
	}

	public void setSku_velocity(String sku_velocity) {
		this.sku_velocity = sku_velocity;
	}
 
	public int getTrk_dlvr_time_days() {
		return trk_dlvr_time_days;
	}

	public void setTrk_dlvr_time_days(int trk_dlvr_time_days) {
		this.trk_dlvr_time_days = trk_dlvr_time_days;
	}

	
	public int getIn_str_qty() {
		return in_str_qty;
	}

	public void setIn_str_qty(int in_str_qty) {
		this.in_str_qty = in_str_qty;
	}

	
	public int getShelf_qty() {
		return shelf_qty;
	}

	public void setShelf_qty(int shelf_qty) {
		this.shelf_qty = shelf_qty;
	}

	
	
	
	
}