package gov.prefect.stock.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.dao.ILigneBonEntreeDao;
import gov.prefect.stock.entites.LigneBonEntree;
import gov.prefect.stock.services.ILigneBonEntreeService;

@Transactional
@Component
public class LigneBonEntreeServiceImpl implements ILigneBonEntreeService {

	@Autowired
	private ILigneBonEntreeDao dao;
	
	@Override
	public LigneBonEntree save(LigneBonEntree entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public LigneBonEntree update(LigneBonEntree entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<LigneBonEntree> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<LigneBonEntree> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneBonEntree getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public LigneBonEntree findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneBonEntree findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
