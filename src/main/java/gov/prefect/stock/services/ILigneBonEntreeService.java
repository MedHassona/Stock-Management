package gov.prefect.stock.services;

import java.util.List;

import gov.prefect.stock.entites.LigneBonEntree;

public interface ILigneBonEntreeService {
	
	public LigneBonEntree save(LigneBonEntree entity);
	
	public LigneBonEntree update(LigneBonEntree entity);
	
	public List<LigneBonEntree> selectAll();
	
	public List<LigneBonEntree> selectAll(String sortField, String sort);
	
	public LigneBonEntree getById(Long id);
	
	public void remove(Long id);
	
	public LigneBonEntree findOne(String paramName, Object paramValue);
	
	public LigneBonEntree findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
