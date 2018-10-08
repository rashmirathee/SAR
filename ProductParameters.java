package com.sar.rs;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;;

@Entity
@Table(name="sar_parm")

public class ProductParameters
{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="SKU_NUMBER")
	private int sku_number;
	
	@Column(name = "SKU_RCMD_THRD")
	private int sku_recmd_thrd;
	
	@Column(name = "TRK_DLVR_FACTOR")
	private int trk_dlvr_factor;
	
	@Column(name = "PACK_SIZE")
	private int pack_size;
	
	@Column(name = "VENDR_MIN")
	private int vendr_min;
	
	@Column(name = "SKU_MARKET")
	private String sku_market;
	
	
	public int getSku_number() {
		return sku_number;
	}


	public void setSku_number(int sku_number) {
		this.sku_number = sku_number;
	}


	public int getSku_recmd_thrd() {
		return sku_recmd_thrd;
	}


	public void setSku_recmd_thrd(int sku_recmd_thrd) {
		this.sku_recmd_thrd = sku_recmd_thrd;
	}


	public int getTrk_dlvr_factor() {
		return trk_dlvr_factor;
	}


	public void setTrk_dlvr_factor(int trk_dlvr_factor) {
		this.trk_dlvr_factor = trk_dlvr_factor;
	}


	public int getPack_size() {
		return pack_size;
	}


	public void setPack_size(int pack_size) {
		this.pack_size = pack_size;
	}


	public int getVendr_min() {
		return vendr_min;
	}


	public void setVendr_min(int vendr_min) {
		this.vendr_min = vendr_min;
	}


	public String getSku_market() {
		return sku_market;
	}


	public void setSku_market(String sku_market) {
		this.sku_market = sku_market;
	}


	
	
	public ProductParameters()
	{
		
	}
	
	
	
}