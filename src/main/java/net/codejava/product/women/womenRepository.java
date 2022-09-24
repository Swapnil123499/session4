package net.codejava.product.women;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface womenRepository extends JpaRepository<Product_women, Integer> {
	@Query("SELECT p FROM Product_women p WHERE p.women_product = ?1")
	Product_women findByWomen_product(String women_product);
}
