package gov.prefect.stock.servicesImpl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.entites.Article;
import gov.prefect.stock.entites.BonSortie;
import gov.prefect.stock.entites.Division;
import gov.prefect.stock.entites.LigneBonSortie;
import gov.prefect.stock.services.IModelBonSortie;

@Transactional
@Component
public class ModelBonSortieImpl implements IModelBonSortie {
	
	private BonSortie bonSortie;
	private Map<Long, LigneBonSortie> ligneBon = new HashMap<Long, LigneBonSortie>();

	@Override
	public void init() {

		bonSortie = null;
		ligneBon.clear();
	}
	
	@Override
	public void creerBons(Division division) {
		if(division == null)
			return;
		bonSortie = new BonSortie();
		bonSortie.setDivision(division);
		bonSortie.setDate(new Date());
		bonSortie.setCode(generateCode());
		
	}
	
	@Override
	public void modifierBon(Division division) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LigneBonSortie ajouterLneBonSortie(Article article) {
		if(article == null) 
			return null;
		if(article.getQteStock().signum() == 0)
			return null;
		
		LigneBonSortie ls = ligneBon.get(article.getIdArticle());
		if(ls != null) {
			BigDecimal qte = ls.getQte().add(BigDecimal.ONE);
			if(qte.compareTo(article.getQteStock()) <= 0 )
			{
				ls.setQte(qte);
				ligneBon.put(article.getIdArticle(), ls);
				return ls;
			}else {
				return ls;				
			}
		}else {
			LigneBonSortie lb = new LigneBonSortie();
			lb.setBonSortie(bonSortie);
			lb.setQte(BigDecimal.ONE);
			lb.setArticle(article);
			ligneBon.put(article.getIdArticle(), lb);
			return lb;
		}
	}

	@Override
	public LigneBonSortie ajouterLneBonSortie(Article article, BigDecimal qte) {
		if(article == null) 
			return null;
		if(article.getQteStock().signum() == 0)
			return null;
		
		LigneBonSortie ls = ligneBon.get(article.getIdArticle());
		if(ls != null) {
			BigDecimal qute = ls.getQte().add(qte);
			if(qute.compareTo(article.getQteStock()) <= 0 )
			{
				ls.setQte(qute);
				ligneBon.put(article.getIdArticle(), ls);
				return ls;
			}else {
				return ls;				
			}
		}else {
			LigneBonSortie lb = new LigneBonSortie();
			lb.setBonSortie(bonSortie);
			lb.setQte(qte);
			lb.setArticle(article);
			ligneBon.put(article.getIdArticle(), lb);
			return lb;
		}
	}
	
	@Override
	public LigneBonSortie supprimerLneBonSortie(Article article) {
		if(article == null)
			return null;
		
		return ligneBon.remove(article.getIdArticle());
	}

	@Override
	public LigneBonSortie modifierQuantite(Article article, double qte) {
		if(article == null)
			return null;
		LigneBonSortie ls = ligneBon.get(article.getIdArticle());
		if(ls == null) 
			return null;
		ls.setQte(BigDecimal.valueOf(qte));
		return ls;
	}
	
	@Override
	public Collection<LigneBonSortie> getLignesBonSortie(BonSortie bon) {
		for (LigneBonSortie l : ligneBon.values()) {
			l.setBonSortie(bon);
		}
		return ligneBon.values();
	}

	@Override
	public String generateCode() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

	@Override
	public BonSortie getBonSortie() {
		return bonSortie;
	}

	public void setBonSortie(BonSortie bonSortie) {
		this.bonSortie = bonSortie;
	}

	@Override
	public Map<Long, LigneBonSortie> getLigneBon() {
		return ligneBon;
	}

	public void setLigneBon(Map<Long, LigneBonSortie> ligneBon) {
		this.ligneBon = ligneBon;
	}
	
	

}
