package gov.prefect.stock.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.prefect.stock.entites.Article;
import gov.prefect.stock.entites.Categorie;
import gov.prefect.stock.export.FileExporter;
import gov.prefect.stock.services.IArticleService;
import gov.prefect.stock.services.ICategorieService;


@Controller
@RequestMapping(value="/articles")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategorieService catservice;
	@Autowired
	@Qualifier("articleExporter")
	FileExporter exporter;
	
	
	@RequestMapping(value="/")
	public String arts(Model model) {
		int t = 0;
		Long id = null;
		List<Article> arts = articleService.selectAll();
		if(arts == null) {
			arts = new ArrayList<>();
		}
		
		model.addAttribute("test", t);
		model.addAttribute("arts",arts);
		model.addAttribute("id",id);
		return "views/stock/articles/articles";
	}
	
	@RequestMapping(value="/stock")
	public String stock(Model model) {
		List<Article> arts = new ArrayList<>();
		Long id = null;
		List<Article> art = articleService.selectAll();
		if(art == null) {
			art = new ArrayList<>();
		}
		
		for (Article article : art) {
			if(article.getQteStock() != null)
				arts.add(article);
		}
		
		model.addAttribute("arts",arts);
		model.addAttribute("id",id);
		return "views/stock/views/stock/articles";
	}
	
	
	
	@RequestMapping(value="/nouveau", method = RequestMethod.GET)
	public String ajouterCategorie(Model model) {
		int t = 1;
		List<Categorie> categories = catservice.selectAll();
		if(categories == null) {
			System.out.println("list Categorie null");
			categories = new ArrayList<Categorie>();
		}
		
		Article article = new Article();
		model.addAttribute("test",t );
		model.addAttribute("cats", categories);
		model.addAttribute("article", article);
		return"views/stock/articles/ajouterArticle";
	}
	
	@RequestMapping(value="/nouveau",method = RequestMethod.POST)
	public String enrgistrerCategorie(Model model, Article article) {
		
		if(article != null) {
			
			if(article.getIdArticle() != null) {
				
				articleService.update(article);				
			}else {
				
				articleService.save(article);
			}
		}
		
		return"redirect:/articles/";
	}
	

	
	@RequestMapping(value="/modifier")
	public String modifier(Model model, Long id) {
		List<Categorie> cats = catservice.selectAll();
		if(cats == null)
			cats = new ArrayList<Categorie>();
		
		
		model.addAttribute("cats", cats);
		Article article = articleService.getById(id);
		model.addAttribute("article",article);
		return "views/stock/articles/ajouterArticle";
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Model model,Long id) {
		if(id != null) {
			Article art = articleService.getById(id);
			if(art != null) {
				articleService.remove(id);
			}
		}
		
		return "redirect:/articles/";
	}
	
	
	@RequestMapping(value="/export")
	public String exportArticles(HttpServletResponse response) {
		exporter.export(response, null, null);
		return"views/stock/articles/articles";
	}

}
