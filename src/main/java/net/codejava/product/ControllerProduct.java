package net.codejava.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.product.child.ChildRepository;
import net.codejava.product.child.Product_child;
import net.codejava.product.men.Product_men;
import net.codejava.product.men.menRepository;
import net.codejava.product.women.Product_women;
import net.codejava.product.women.womenRepository;

@Controller
public class ControllerProduct {
	@Autowired
	private ChildRepository repo;
	@Autowired
	private menRepository repo2;
	@Autowired
	private womenRepository repo3;
	//****************customer Home Page**********************************//
	
  
   
   //********************************************************************//
   //*************Add child product********************************//
   
   @GetMapping("/child")
   public String AddChild(Model model) {
	   model.addAttribute( "child",new Product_child());
	   
	   return"/prod/ADD/ADD_Child";
   }
   @PostMapping("/Child")
   public String childshoes(Product_child childproduct,Model model) {
	   repo.save(childproduct);
	   //**************************************//
	   List<Product_child> allchild =  repo.findAll();
		model.addAttribute("allchild",allchild);
		List<Product_men> allmen = repo2.findAll();
		model.addAttribute("allmen", allmen);
		List<Product_women> allwomen =repo3.findAll();
		model.addAttribute("allwomen", allwomen);
		//*********************************************//
	   return"/prod/Shoes";
   }
   //*************************Add men product***********************//
   
   @GetMapping("/men")
   public String Addmen(Model model) {
	   model.addAttribute("men", new Product_men());
	   
	   return"/prod/ADD/ADD_Men";
   }
   
   @PostMapping("/Men")
   public String menshoes(Product_men menproduct,Model model) {
	   repo2.save(menproduct);
	   List<Product_child> allchild =  repo.findAll();
		model.addAttribute("allchild",allchild);
		List<Product_men> allmen = repo2.findAll();
		model.addAttribute("allmen", allmen);
		List<Product_women> allwomen =repo3.findAll();
		model.addAttribute("allwomen", allwomen);
	   return"/prod/Shoes";
   }
   
   //********************Add women product**************************//
   @GetMapping("/women")
   public String Addwomen(Model model) {
	   model.addAttribute("women", new Product_women());
	   return"/prod/ADD/ADD_Women";
   }
   @PostMapping("/Women")
   public String womenshoes(Product_women womenproduct,Model model) {
	   repo3.save(womenproduct);
	   List<Product_child> allchild =  repo.findAll();
		model.addAttribute("allchild",allchild);
		List<Product_men> allmen = repo2.findAll();
		model.addAttribute("allmen", allmen);
		List<Product_women> allwomen =repo3.findAll();
		model.addAttribute("allwomen", allwomen);
	   return"/prod/Shoes";
   }
   
   //******************************All List of product*************************//
   
   
   @GetMapping("/show")
  public String Showproduct(Model model) {
	List<Product_child> allchild =  repo.findAll();
	model.addAttribute("allchild",allchild);
	List<Product_men> allmen = repo2.findAll();
	model.addAttribute("allmen", allmen);
	List<Product_women> allwomen =repo3.findAll();
	model.addAttribute("allwomen", allwomen);
	  return"/prod/Shoes";
  }
   //************************************delete the child product************************//
   
   @GetMapping("/childdelete")
   public String childprodelete(Model model) {
	  model.addAttribute("delete", new Product_child());
	   
	   
	   return"/prod/DELETE/childdel";
   }
   
   @PostMapping("/deleted")
   public String childdeleted( @RequestParam("id") int id,Model model) {
	   List<Product_child> prods =   repo.findAll();
		for(Product_child prod:prods)
		{
			 if(prod.getId()==id) {
		
	   
	   repo.deleteById(id);
	   List<Product_child> allchild =  repo.findAll();
		model.addAttribute("allchild",allchild);
		List<Product_men> allmen = repo2.findAll();
		model.addAttribute("allmen", allmen);
		List<Product_women> allwomen =repo3.findAll();
		model.addAttribute("allwomen", allwomen);
	   
	   return"/prod/Shoes";
   }}
		model.addAttribute("statment", "Sorry the product number is wrong or product are not available");
		
		 List<Product_child> allchild =  repo.findAll();
			model.addAttribute("allchild",allchild);
			List<Product_men> allmen = repo2.findAll();
			model.addAttribute("allmen", allmen);
			List<Product_women> allwomen =repo3.findAll();
			model.addAttribute("allwomen", allwomen);
			
		return"/prod/Shoes";
			 
			 }
   //********************************delete men product************************************************//
   @GetMapping("/mendelete")
   public String menprodelete(Model model) {
	  model.addAttribute("delete", new Product_men());
	   
	   
	   return"/prod/DELETE/mendel";
   }
	   
	   
   @PostMapping("/deleted2")
   public String mendeleted( @RequestParam("id") int id,Model model) {
	List<Product_men> prods =   repo2.findAll();
	for(Product_men prod:prods)
	{
	  if(prod.getId()==id) {
	   
	   repo2.deleteById(id);
	   List<Product_child> allchild =  repo.findAll();
		model.addAttribute("allchild",allchild);
		List<Product_men> allmen = repo2.findAll();
		model.addAttribute("allmen", allmen);
		List<Product_women> allwomen =repo3.findAll();
		model.addAttribute("allwomen", allwomen);
	   return"/prod/Shoes";
	  }
   }
	model.addAttribute("statment", "Sorry the product number is wrong or product are not available");
	
	 List<Product_child> allchild =  repo.findAll();
		model.addAttribute("allchild",allchild);
		List<Product_men> allmen = repo2.findAll();
		model.addAttribute("allmen", allmen);
		List<Product_women> allwomen =repo3.findAll();
		model.addAttribute("allwomen", allwomen);
		
	return"/prod/Shoes";
   }
   
   //****************************delete women product******************************//
   
   @GetMapping("/womendelete")
   public String womenprodelete(Model model) {
	  model.addAttribute("delete", new Product_women());
	   
	   
	   return"/prod/DELETE/womendel";
   }
   
   @PostMapping("/deleted3")
   public String womendeleted( @RequestParam("id") int id,Model model) {
	   List<Product_women> prods =   repo3.findAll();
		for(Product_women prod:prods)
		{
		  if(prod.getId()==id) {
		   
	   
	   repo3.deleteById(id);
	   
	   List<Product_child> allchild =  repo.findAll();
		model.addAttribute("allchild",allchild);
		List<Product_men> allmen = repo2.findAll();
		model.addAttribute("allmen", allmen);
		List<Product_women> allwomen =repo3.findAll();
		model.addAttribute("allwomen", allwomen);
	   return"/prod/Shoes";
		  }}
		model.addAttribute("statment", "Sorry the product number is wrong or product are not available");
		
		 List<Product_child> allchild =  repo.findAll();
			model.addAttribute("allchild",allchild);
			List<Product_men> allmen = repo2.findAll();
			model.addAttribute("allmen", allmen);
			List<Product_women> allwomen =repo3.findAll();
			model.addAttribute("allwomen", allwomen);
			
		return"/prod/Shoes";
	   
   }
   
}
