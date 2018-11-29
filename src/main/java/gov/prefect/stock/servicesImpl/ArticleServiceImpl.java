package gov.prefect.stock.servicesImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.dao.IArticleDao;
import gov.prefect.stock.entites.Article;
import gov.prefect.stock.services.IArticleService;

@Transactional
@Component
public class ArticleServiceImpl implements IArticleService{

	@Autowired
	private IArticleDao dao;
	
	@Override
	public Article save(Article entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Article update(Article entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Article> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
	@Override
	public List<Article> selectArticles() {
		List<Article> arts = dao.selectAll();
		List<Article> a = new ArrayList<>();
		for (Article article : arts) {
			if(article.getQteStock().signum() != 0)
				a.add(article);
		}
		return a;
	}

	@Override
	public List<Article> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Article getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Article findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Article findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}
	
	@Override
	public void modifierQte(Article article, BigDecimal qte) {
		BigDecimal q = article.getQteStock();
		article.setQteStock(q.subtract(qte));
		dao.update(article);
	}

}
