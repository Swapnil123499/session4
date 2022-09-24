package net.codejava.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class demoController {
	@Autowired
	private User2Repository userRepo;
	
@GetMapping("/customer")	
public String demo(Model model) {
	model.addAttribute("customer", new User2());
	return"/prod/customer/demo";
}
@PostMapping("/buy")
public String Buy(User2 user) {
	LocalDate date= LocalDate.now();
	user.setDate(date);
	
	userRepo.save(user);
	return"/prod/customer/success";
}

//************************UserList********************//
@GetMapping("/List")
public String Users(Model model) {
	List<User2> userlist =userRepo.findAll();
	model.addAttribute("userlist", userlist);
	return"/prod/customer/listcustomer/userAlllist";
}

//***********search the user code***************************//
@PostMapping("/search")
public String Searchuser(@RequestParam("nam") String name,Model model) {
	List<User2>listuser =  userRepo.findByName(name);
	model.addAttribute("userlist", listuser);
	return"/prod/customer/listcustomer/userAlllist";
}

//*****************************filter by date and category search *****************************************//
@GetMapping("/filter")
public String filter(Model model) {
	List<User2> filter1= userRepo.findByCategory("Category_Women");
	List<User2> filter2= userRepo.findByCategory("Category_Men");
	List<User2> filter3= userRepo.findByCategory("Category_Child");
	
	List<User2>filter11=new ArrayList<>();// this array for the women
	List<User2>filter22=new ArrayList<>();// this array for the men
	List<User2>filter33=new ArrayList<>();// this array for the child
	
	for(int i= (filter1.size()) - 1;i>=0;i--) {
		
		filter11.add(filter1.get(i));		
	}
	
	for(int j=filter2.size()-1;j>=0;j--) {
		
		filter22.add(filter2.get(j));
		
	}
	
for(int k=filter3.size()-1;k>=0;k--) {
		
		filter33.add(filter3.get(k));
		
	}
	
	
	
	model.addAttribute("filter33", filter33);
	model.addAttribute("filter22", filter22);
	model.addAttribute("filter11", filter11);
	
	return"/prod/customer/listcustomer/filter";
}

}
