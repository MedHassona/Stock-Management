package gov.prefect.stock.services;

import java.util.List;

import gov.prefect.stock.entites.LigneBonSortie;

public interface ILigneBonSortieService {
	
	public LigneBonSortie save(LigneBonSortie entity);
	
	public LigneBonSortie update(LigneBonSortie entity);
	
	public List<LigneBonSortie> selectAll();
	
	public List<LigneBonSortie> selectAll(String sortField, String sort);
	
	public LigneBonSortie getById(Long id);
	
	public void remove(Long id);
	
	public LigneBonSortie findOne(String paramName, Object paramValue);
	
	public LigneBonSortie findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
