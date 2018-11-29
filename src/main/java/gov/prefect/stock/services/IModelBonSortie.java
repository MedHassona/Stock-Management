package gov.prefect.stock.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import gov.prefect.stock.entites.Article;
import gov.prefect.stock.entites.BonSortie;
import gov.prefect.stock.entites.Division;
import gov.prefect.stock.entites.LigneBonSortie;

public interface IModelBonSortie {
	
	void init();
	
	void creerBons(Division division);
	
	void modifierBon(Division division);
	
	LigneBonSortie ajouterLneBonSortie(Article article);
	
	LigneBonSortie ajouterLneBonSortie(Article article, BigDecimal qte);
	
	LigneBonSortie supprimerLneBonSortie(Article article);
	
	LigneBonSortie modifierQuantite(Article article, double qte);
	
	String generateCode();
	
	BonSortie getBonSortie();
	
	Map<Long, LigneBonSortie> getLigneBon();
	
	Collection<LigneBonSortie> getLignesBonSortie(BonSortie bon);
	

}
