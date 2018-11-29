package gov.prefect.stock.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.dao.ILigneBonSortieDao;
import gov.prefect.stock.entites.LigneBonSortie;
import gov.prefect.stock.services.ILigneBonSortieService;

@Transactional
@Component
public class LigneBonServiceImpl implements ILigneBonSortieService {

	@Autowired
	private ILigneBonSortieDao dao; 
	
	@Override
	public LigneBonSortie save(LigneBonSortie entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public LigneBonSortie update(LigneBonSortie entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<LigneBonSortie> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<LigneBonSortie> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneBonSortie getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public LigneBonSortie findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneBonSortie findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
