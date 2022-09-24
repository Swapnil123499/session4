package net.codejava.product.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product_women {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String women_product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWomen_product() {
		return women_product;
	}
	public void setWomen_product(String women_product) {
		this.women_product = women_product;
	}

	
	
}
