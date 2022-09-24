package net.codejava;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.user.User2Repository;
 
@Controller
public class AppController {
 
   @Autowired
    private UserRepository userRepo;
  
     
    @GetMapping("/asa")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/register")
    public String showsignupForm(Model model) {
    	model.addAttribute("user", new User());
    	
    	return "signup_form";
    }
    	
    	@PostMapping("/process_register")
    	public String processRegistration(User user,Model model) {
    		
    		String username=user.getEmail();
    		System.out.println(username);
    		
    		List<User> used=userRepo.findAll();
    		
    		for(User uss:used)
    		{
    			String ussname=uss.getEmail();
    			
    			if(username.equalsIgnoreCase(ussname)) {
    				
    				model.addAttribute("statments", "emails are already exist....................!");
    				
    				
    				return "signup_form";
    			}
    		}
    		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
    		String encodedPassword =encoder.encode(user.getPassword());
    		user.setPassword(encodedPassword);
    		userRepo.save(user);
    	return"register_success";
    }
    	@GetMapping("/list_users")
    	public String viewUsersList(Model model) {
    		
    		List<User> listUsers = userRepo.findAll();
    		model.addAttribute("listUsers", listUsers);
    		
    		return "users";
    	}
    	@GetMapping("/Admin")
    	public String Change_pass() {
    		return "aaa";
    	}
    	
    	
    	@PostMapping("/ADchange")
    	public String Pass(
    			@RequestParam("EMAIL") String useremail,
    			@RequestParam("PASSWORD") String userpass,
    			@RequestParam("ID") int id,Model model) {
    
//    	
    		
    		BCryptPasswordEncoder encoder1= new BCryptPasswordEncoder();
  		String encodedPassword1 =encoder1.encode(userpass);
    		List<User>uss=userRepo.findAll();
    		
    		for(User usss:uss) {
    			String usemail=usss.getEmail();
    			
    			if(usemail.equals(useremail))
    			{     usss.setPassword(encodedPassword1);   
    			userRepo.save(usss);
    	return"bbb";
    		
    		
    			
    			}}
    		model.addAttribute("statments", "the wrong user name.........");
    		
    		return "ccc";
    	
}
    	//....................................
    	@GetMapping("/ccc2")
    	public String ccc() {
    		return "ccc2";
    	}
    	@GetMapping("/welcome")
    	public String Wecome() {
    		return "Shop";
    	}
}
