package gov.prefect.stock.services;

import java.util.List;

import gov.prefect.stock.entites.BonSortie;
import gov.prefect.stock.entites.LigneBonSortie;
import gov.prefect.stock.utils.Outil;

public interface IBonSortieService {
	
	public BonSortie save(BonSortie entity);
	
	public BonSortie update(BonSortie entity);
	
	public List<BonSortie> selectAll();
	
	public List<BonSortie> selectAll(String sortField, String sort);
	
	public BonSortie getById(Long id);
	
	public void remove(Long id);
	
	public BonSortie findOne(String paramName, Object paramValue);
	
	public BonSortie findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	public List<LigneBonSortie> getLsByIdBonSortie(Long idBonSortie);
	
	public List<BonSortie> chercher(Outil outil);

}
