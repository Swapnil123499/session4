package net.codejava.product.child;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChildRepository extends JpaRepository<Product_child, Integer> {

	@Query("SELECT p FROM Product_child p WHERE p.product = ?1")
	Product_child findByProduct(String product);
	
Product_child deleteByProduct(String product);
	
}
