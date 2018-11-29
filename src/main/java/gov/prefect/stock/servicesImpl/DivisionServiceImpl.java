package gov.prefect.stock.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.dao.IDivisionDao;
import gov.prefect.stock.entites.Division;
import gov.prefect.stock.services.IDivisionService;

@Transactional
@Component
public class DivisionServiceImpl implements IDivisionService {
	
	@Autowired
	private IDivisionDao dao;

	@Override
	public List<Division> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Division save(Division entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Division update(Division entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Division> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Division getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public Division findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Division findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
