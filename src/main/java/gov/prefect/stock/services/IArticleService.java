package gov.prefect.stock.services;


import java.math.BigDecimal;
import java.util.List;

import gov.prefect.stock.entites.Article;


public interface IArticleService {
	
	public Article save(Article entity);
	
	public Article update(Article entity);
	
	public List<Article> selectAll();
	
	public List<Article> selectArticles();
	
	public List<Article> selectAll(String sortField, String sort);
	
	public Article getById(Long id);
	
	public void remove(Long id);
	
	public Article findOne(String paramName, Object paramValue);
	
	public Article findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	public void modifierQte(Article article, BigDecimal qte);
}
