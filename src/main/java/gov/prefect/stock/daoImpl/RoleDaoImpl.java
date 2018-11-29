package gov.prefect.stock.daoImpl;

import org.springframework.stereotype.Component;

import gov.prefect.security.entities.Role;
import gov.prefect.stock.dao.IRoleDao;

@Component
public class RoleDaoImpl extends GenericDaoImpl<Role> implements IRoleDao {

}
