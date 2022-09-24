package net.codejava.product.men;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.product.child.Product_child;

public interface menRepository extends JpaRepository<Product_men, Integer> {

	@Query("SELECT p FROM Product_men p WHERE p.men_product = ?1")
	Product_men findByMen_product(String men_product);
}
