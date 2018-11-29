package gov.prefect.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.prefect.stock.entites.Categorie;
import gov.prefect.stock.services.ICategorieService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="/categories")
public class CategorieController {
	
	@Autowired
	private ICategorieService catservice;
	
	@RequestMapping(value="/")
	public String lesCats(Model model) {
	
		Long id = null;
		List<Categorie> cats = catservice.selectAll();
		if(cats == null)
			cats = new ArrayList<Categorie>();
		
		model.addAttribute("id",id);
		model.addAttribute("cats", cats);
		
		return"views/stock/categories/categories";
	}
	
	@RequestMapping(value="/nouveau", method = RequestMethod.GET)
	public String ajouterCategorie(Model model) {
		
		Categorie categorie = new Categorie();
		model.addAttribute("categorie", categorie);
		return"views/stock/categories/ajouterCategorie";
	}
	
	@RequestMapping(value="/nouveau",method = RequestMethod.POST)
	public String enrgistrerCategorie(Model model, Categorie categorie, Long id) {
		
		if(categorie != null) {
			
			if(categorie.getIdCategory() != null) {
		
				catservice.update(categorie);			
			}else {
				
				catservice.save(categorie);
			}
		}
		

		return"redirect:/categories/";
	}
	
	@RequestMapping(value="/modifier",method = RequestMethod.GET)
	public String modifierCategorie(Model model, Long id) {

		if(id != null) {
			Categorie categorie = catservice.getById(id);
			
			model.addAttribute("id",id);
			model.addAttribute("categorie", categorie);
		}
		
		
		return"views/stock/categories/ajouterCategorie";
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Model model,Long id) {
		if(id != null) {
			Categorie cat = catservice.getById(id);
			if(cat != null) {
				catservice.remove(id);
			}
		}
		
		return "redirect:/categories/";
	
	}

}
