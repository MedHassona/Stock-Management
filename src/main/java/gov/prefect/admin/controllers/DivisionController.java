package gov.prefect.admin.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.prefect.stock.entites.Division;
import gov.prefect.stock.services.IDivisionService;


@Controller
@RequestMapping(value="/divisions")
public class DivisionController {
	
	@Autowired
	private IDivisionService divisionService;
	
	@RequestMapping(value="/")
	public String lister(Model model) {
		List<Division> divisions = divisionService.selectAll();
		if(divisions == null) {
			divisions = new ArrayList<Division>();
		}
		model.addAttribute("divs", divisions);
		return "views/admin/divisions/divisions";
	}
	
	@RequestMapping(value="/nouveau",method = RequestMethod.GET)
	public String nouveau(Model model) {
		Division division = new Division();
		model.addAttribute("division", division);
		return "views/admin/divisions/ajouterDivision";
	}
	
	@RequestMapping(value="/nouveau",method = RequestMethod.POST)
	public String Enregistrer(Model model, Division division) {
		if(division != null) {
			divisionService.save(division);
		}
		
		return "redirect:/divisions/";
	}

}
