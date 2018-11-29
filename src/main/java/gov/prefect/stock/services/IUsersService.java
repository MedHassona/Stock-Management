package gov.prefect.stock.services;

import java.util.List;

import gov.prefect.security.entities.User;

public interface IUsersService {
	
public User save(User entity);
	
	public User update(User entity);
	
	public List<User> selectAll();
	
	public List<User> selectAll(String sortField, String sort);
	
	public User getById(Long id);
	
	public void remove(Long id);
	
	public User findOne(String paramName, Object paramValue);
	
	public User findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
