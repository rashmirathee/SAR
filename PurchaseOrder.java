package com.sar.rs;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "po_number")
public class PurchaseOrder implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "last_po_num")
	private int po_num;
	
	
	public int getPo_num() {
		return po_num;
	}

	public void setPo_num(int po_num) {
		this.po_num = po_num;
	}
	
	public PurchaseOrder()
	{
		
	}
	
	
	
}