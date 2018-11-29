package gov.prefect.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.prefect.stock.entites.Division;
import gov.prefect.stock.services.IDivisionService;

@org.springframework.stereotype.Controller
public class SecurityController {
	
	@Autowired
	private IDivisionService divisionService;
	
	@RequestMapping(value="/login")
	public String blank() {
		return"thymeleaf/login.html";
	}
	
	@RequestMapping(value="/")
	public String home() {
		return"views/stock/home";
	}

	@RequestMapping(value="/reporting")
	public String reporting(Model model) {
		List<Division> divs = divisionService.selectAll();
		for (Division division : divs) {
			System.out.println(division.getBons_Sortie().size());			
		}
		model.addAttribute("divs", divs);
		return"views/stock/reporting/reporting";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	@RequestMapping(value="/deny", method = RequestMethod.GET)
	public String deby() {
		return"views/deny";
	}
}
