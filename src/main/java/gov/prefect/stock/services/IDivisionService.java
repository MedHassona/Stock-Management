package gov.prefect.stock.services;

import java.util.List;

import gov.prefect.stock.entites.Division;

public interface IDivisionService {
public Division save(Division entity);
	
	public Division update(Division entity);

	public List<Division> selectAll();
	
	public List<Division> selectAll(String sortField, String sort);
	
	public Division getById(Long id);
	
	public void remove(Long id);
	
	public Division findOne(String paramName, Object paramValue);
	
	public Division findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
