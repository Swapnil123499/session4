package net.codejava.product.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Child_product")
public class Product_child {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
@Column(name="product_name")
private String product;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}



}
