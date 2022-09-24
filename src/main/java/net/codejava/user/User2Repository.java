package net.codejava.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codejava.User;

public interface User2Repository extends JpaRepository<User2, Integer> {
	 @Query("SELECT r FROM User2 r WHERE r.name =?1")
//		User findByName (String name);
	 
	 public List<User2> findByName (String name2);
	 
	 @Query("SELECT c FROM User2 c WHERE c.category =?1")
	 
	 public List<User2> findByCategory (String category2);

}
