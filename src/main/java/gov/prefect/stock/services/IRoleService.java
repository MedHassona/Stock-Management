package gov.prefect.stock.services;

import java.util.List;

import gov.prefect.security.entities.Role;

public interface IRoleService {
	
	public List<Role> selectAll();

	public List<Role> selectAll(String sortField, String sort);
}
