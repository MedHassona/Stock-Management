package gov.prefect.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.prefect.stock.entites.Fournisseur;
import gov.prefect.stock.services.IFournisseurService;

import java.util.ArrayList;
import java.util.List;


@Controller
//@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping(value="/fournisseurs")
public class FournisseurController {
	
	
	@Autowired
	private IFournisseurService fournisseurService;
	
	
	@RequestMapping(value="/")
	public String fournisseurs(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(fournisseurs == null) {
			fournisseurs = new ArrayList<>();
		}
		
		model.addAttribute("fours", fournisseurs);
		
		return"views/stock/fournisseurs/fournisseurs";
	}
	
	
	@RequestMapping(value="/nouveau", method = RequestMethod.GET)
	public String nouveau(Model model) {
		System.out.println("out of the list");
		Fournisseur fournisseur = new Fournisseur();
		
		model.addAttribute("fournisseur", fournisseur);
		return "views/stock/fournisseurs/ajouterFournisseur";
	}
	
	
	@RequestMapping(value="/nouveau",method = RequestMethod.POST)
	public String enrgistrerCategorie(Model model, Fournisseur fournisseur) {
		
		if(fournisseur != null) {
			if(fournisseur.getId() != null) {
				fournisseurService.update(fournisseur);

			}else {
				
				fournisseurService.save(fournisseur);
			}
		}
		
		return"redirect:/fournisseurs/";
	}
	
	
	@RequestMapping(value="/modifier")
	public String modifier(Model model,Long id) {
		if(id != null) {
			Fournisseur fournisseur = fournisseurService.getById(id);
			if(fournisseur != null) {
				model.addAttribute("fournisseur",fournisseur);
			}
		}
		
		return "views/stock/fournisseurs/ajouterFournisseur";
	}
	
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Model model,Long id) {
		if(id != null) {
			Fournisseur four = fournisseurService.getById(id);
			if(four != null) {
				fournisseurService.remove(id);
			}
		}
		
		return "redirect:/fournisseurs/";
	}
	
	
}
