package gov.prefect.stock.services;

import java.util.List;

import gov.prefect.stock.entites.BonEntree;

public interface IBonEntreeService {
	
    public BonEntree save(BonEntree entity);
	
	public BonEntree update(BonEntree entity);
	
	public List<BonEntree> selectAll();
	
	public List<BonEntree> selectAll(String sortField, String sort);
	
	public BonEntree getById(Long id);
	
	public void remove(Long id);
	
	public BonEntree findOne(String paramName, Object paramValue);
	
	public BonEntree findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
