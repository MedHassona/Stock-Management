package gov.prefect.stock.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gov.prefect.stock.entites.Article;
import gov.prefect.stock.entites.BonSortie;
import gov.prefect.stock.entites.Division;
import gov.prefect.stock.entites.LigneBonSortie;
import gov.prefect.stock.services.IArticleService;
import gov.prefect.stock.services.IBonSortieService;
import gov.prefect.stock.services.IDivisionService;
import gov.prefect.stock.services.ILigneBonSortieService;
import gov.prefect.stock.services.IModelBonSortie;
import gov.prefect.stock.utils.Outil;

@Controller
@RequestMapping(value="/bonSortie")
public class BonSortieController {
	
	@Autowired
	private IBonSortieService bonSortieService;
	@Autowired
	private IDivisionService divisionService;
	@Autowired 
	private IModelBonSortie modelBonSortie;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ILigneBonSortieService ligneBonService;
	

	@RequestMapping(value="/")
	public String listerSortie(Model model,Long idB) {
		List<BonSortie> bonsSortie = bonSortieService.selectAll();
		
		if(bonsSortie.isEmpty()) {
			bonsSortie = new ArrayList<BonSortie>();
		}
		
		model.addAttribute("bons", bonsSortie);
		return "views/stock/bonSortie/bons";
	}
	
	/*********************************** création nd'un nnouveau bon de sortie ********************************/
	
	@RequestMapping(value="/nouveauS")
	public String nouveau(Model model) {
		List<Division> divisions = divisionService.selectAll();
		List<Article> arts = articleService.selectArticles();
		
		if(arts.isEmpty())
		arts = new ArrayList<Article>();
	
		model.addAttribute("arts", arts);
		model.addAttribute("divs",divisions);
		return"views/stock/bonSortie/nouveauBon";
	}
	
	@RequestMapping(value="/creerBonS")
	@ResponseBody
	public BonSortie creerBon(final String nomD) {
		
		if(nomD == null)
			return null;
		Division division = divisionService.findOne("nomDivision", nomD);
		if(division == null)
			return null;
		modelBonSortie.creerBons(division);
		BonSortie b = modelBonSortie.getBonSortie(); 
		System.out.println(b.getCode()+" : "+b.getDate());
		return b;
	}
	
	@RequestMapping(value="/ajouterLigneS")
	@ResponseBody
	public LigneBonSortie detailArticle(final Long codeArticle) {
		if(codeArticle == null)
			return null;
		Article article = articleService.findOne("codeArticle",codeArticle);
		if(article == null) {
			return null;
		}
		LigneBonSortie l = modelBonSortie.ajouterLneBonSortie(article);
		return l;
	}
	
	@RequestMapping(value="/plusQuantite")
	@ResponseBody
	public LigneBonSortie plusQuantite(final Long code, final BigDecimal qte) {
		if(code == null)
			return null;
		Article article = articleService.findOne("codeArticle",code);
		if(article == null) {
			return null;
		}
		LigneBonSortie l = modelBonSortie.ajouterLneBonSortie(article,qte);
		return l;
	}
	
	@RequestMapping(value="/supprimerLigneS")
	@ResponseBody
	public LigneBonSortie supprimerLigneS(final Long idArticle) {
		if(idArticle == null)
			return null;
		Article article = articleService.getById(idArticle);
		if(article == null)
			return null;
		return modelBonSortie.supprimerLneBonSortie(article);
	}
	
	@RequestMapping(value="/enrgistrerBonS")
	@ResponseBody
	public String enrigstrerBonS(HttpServletRequest request) {
		BonSortie nouveauBon = null;
		if(modelBonSortie.getBonSortie() != null) {
			nouveauBon = bonSortieService.save(modelBonSortie.getBonSortie());
		}
		if(nouveauBon != null) {
			Collection<LigneBonSortie> lignesBon = modelBonSortie.getLignesBonSortie(nouveauBon);
			if(lignesBon != null && !lignesBon.isEmpty()) {
				
				for (LigneBonSortie ligneBonSortie : lignesBon) {
					ligneBonService.save(ligneBonSortie);
					articleService.modifierQte(ligneBonSortie.getArticle(), ligneBonSortie.getQte());
				}
				modelBonSortie.init();
			}
		}
		System.out.println(request.getContextPath()+"/bonSortie");
		return "http://localhost:5050/bonSortie/";
	}
	
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Model modeln, final Long id) {
		if(id != null) {
			BonSortie bon = bonSortieService.getById(id);
			if(bon != null) {
				System.out.println("BON NOT NULL");
				if(!bon.getLignesSortie().isEmpty()) {
					System.out.println("LIGNES DE BON NOT EMPTY");
					List<LigneBonSortie> l = bon.getLignesSortie();
					for (LigneBonSortie ligneBonSortie : l) {
						System.out.println(ligneBonSortie.getIdLigneSortie());
						ligneBonService.remove(ligneBonSortie.getIdLigneSortie());
					}
				}
				bonSortieService.remove(id);
			}
		}
		return "redirect:/bonSortie/";
	}
	
	@RequestMapping(value="/modifier")
	public String modifier(Model model, final Long id) {
		List<LigneBonSortie> lignes = null;
		BonSortie bon = null;
		if(id != null) {
			 bon = bonSortieService.getById(id);
			if(bon != null) {
				lignes = bon.getLignesSortie();
				if(lignes.isEmpty())
					lignes = new ArrayList<>();
			}
		}
		model.addAttribute("bon", bon);
		model.addAttribute("lignes", lignes);
		return"views/stock/bonSortie/modifier";
	}
	
	@RequestMapping(value="/chercher", method = RequestMethod.GET)
	public String chercher(Model model) {
		Outil outil = new Outil();

		List<Division> divisions = divisionService.selectAll();
 
		model.addAttribute("indice", "-1");
		model.addAttribute("outil", outil);
		model.addAttribute("divs",divisions);
		return "views/stock/bonSortie/chercher";
	}
	
	@RequestMapping(value="/chercher", method = RequestMethod.POST)
	public String resultChercher(Model model, Outil outil) {
		List<Division> divisions = divisionService.selectAll();
		List<BonSortie> bons = null;
		if(outil != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String dateD = outil.getDateD()+" 00:00:01";
			String dateF = outil.getDateF()+" 00:00:01";
			
			Date dateDebut = null;
			Date dateFin = null;
			try {
				dateDebut = formatter.parse(dateD);
				dateFin = formatter.parse(dateF);
				
				outil.setDateDebut(dateDebut);
				outil.setDateFin(dateFin);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(outil.getDivision().getNomDivision());
			bons = bonSortieService.chercher(outil);
		}

		if( !bons.isEmpty()) {
			model.addAttribute("indice", "1");
			System.out.println("------------------------bons not EMPTY--------------");
			for (BonSortie bonSortie : bons) {
				System.out.println(bonSortie.getDate());
			}
			System.out.println(outil.getDateD());
		}
		else {
			model.addAttribute("indice", "-1");
			System.out.println("------------------------bons is EMPTY--------------");
		}
		
			
		outil = new Outil();
		model.addAttribute("outil", outil);
		model.addAttribute("bons", bons);		
		model.addAttribute("divs",divisions);

		return"views/stock/bonSortie/chercher";
	}
	

}
