package gov.prefect.stock.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gov.prefect.stock.dao.IBonSortieDao;
import gov.prefect.stock.entites.BonSortie;
import gov.prefect.stock.entites.LigneBonSortie;
import gov.prefect.stock.services.IBonSortieService;
import gov.prefect.stock.utils.Outil;

@Transactional
@Component
public class BonSortieServiceImpl implements IBonSortieService {

	@Autowired
	private IBonSortieDao dao;
	
	@Override
	public BonSortie save(BonSortie entity) {
		
		return dao.save(entity);
	}

	@Override
	public BonSortie update(BonSortie entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<BonSortie> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<BonSortie> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public BonSortie getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public BonSortie findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public BonSortie findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<LigneBonSortie> getLsByIdBonSortie(Long idBonSortie) {
		// TODO Auto-generated method stub
		return dao.getByIdBonSortie(idBonSortie);
	}
	
	@Override
	public List<BonSortie> chercher(Outil outil) {
		// TODO Auto-generated method stub
		if(outil != null)
		return dao.chercher(outil);
		
		
		return null;
	}

}
