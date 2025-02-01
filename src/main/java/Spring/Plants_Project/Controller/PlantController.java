package Spring.Plants_Project.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Spring.Plants_Project.Dao.PlantService;
import Spring.Plants_Project.Module.Plants;

@Controller
public class PlantController {
	
	private PlantService plantService;
	Plants thePlants = new Plants(); 
	
	public PlantController( PlantService plantService) {
		super();
		this.plantService=plantService;
		
	}
	
	@Value("${login.username}")
	private String userName;
	
	@Value("${login.password}")
	private String password;
	
	

	@RequestMapping("/")
	public String showIndex(Model theModel) {
	    theModel.addAttribute("thePlants", new Plants());
	    return "index";
	}
	
	@PostMapping("/save")
	public String saveCustomerInfo(Model theModel,@ModelAttribute("thePlants") Plants thePlants ) {
		
		//save the customers
		System.out.println("Data to save is : "+thePlants);
		
		plantService.save(thePlants);
		theModel.addAttribute("thePlants",thePlants);
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/custList")

	public String listDetails(Model theModel) {

	List<Plants> plantCustomer=plantService.findAll();
		theModel.addAttribute("listing",plantCustomer);
		
	return "list";
		}

	@RequestMapping("/return")
		public String displayList(@ModelAttribute("thePlants") Plants plants) {
	
		return "redirect:/";
	
}
	
	@RequestMapping("/showLogin")
	
	public String loginForm(Model theModel) {
		
		theModel.addAttribute("login", new Spring.Plants_Project.Module.Login());
		return "login_form";
	}
	

	@RequestMapping("/submitLogin")
	
	public String showList(@ModelAttribute("login") Spring.Plants_Project.Module.Login login, Model theModel) {
		if(userName.equals(login.getUsername())) {
		
			List<Plants> plantCustomer=plantService.findAll();
			theModel.addAttribute("listing",plantCustomer);
			
		return "list";
		
		
		}
		else {
			return "loginForm";
		}
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int  theId) {
		// delete the customer
		plantService.deleteById(theId);

		return "redirect:/custList";   //custList name of endpoint which displays list
		

	}
	

}
