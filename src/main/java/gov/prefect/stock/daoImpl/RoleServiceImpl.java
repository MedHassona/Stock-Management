package gov.prefect.stock.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.prefect.security.entities.Role;
import gov.prefect.stock.dao.IRoleDao;
import gov.prefect.stock.services.IRoleService;

@Transactional
@Component
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao dao;

	@Override
	public List<Role> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public List<Role> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

}
