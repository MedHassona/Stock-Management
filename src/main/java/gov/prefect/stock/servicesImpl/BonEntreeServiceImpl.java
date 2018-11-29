package gov.prefect.stock.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.dao.IBonEntreeDao;
import gov.prefect.stock.entites.BonEntree;
import gov.prefect.stock.services.IBonEntreeService;

@Transactional
@Component
public class BonEntreeServiceImpl implements IBonEntreeService {

	@Autowired
	private IBonEntreeDao dao;
	
	@Override
	public BonEntree save(BonEntree entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public BonEntree update(BonEntree entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<BonEntree> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<BonEntree> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public BonEntree getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public BonEntree findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public BonEntree findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
