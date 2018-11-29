package gov.prefect.stock.servicesImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.dao.ICategorieDao;
import gov.prefect.stock.entites.Categorie;
import gov.prefect.stock.services.ICategorieService;

@Transactional
@Component
public class CategorieServiceImpl implements ICategorieService {

	@Autowired
	private ICategorieDao dao;
	
	@Override
	public Categorie save(Categorie entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Categorie update(Categorie entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Categorie> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Categorie> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Categorie getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Categorie findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Categorie findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
