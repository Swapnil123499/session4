package net.codejava.product.men;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product_men {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String men_product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMen_product() {
		return men_product;
	}

	public void setMen_product(String men_product) {
		this.men_product = men_product;
	}
	
	
}
