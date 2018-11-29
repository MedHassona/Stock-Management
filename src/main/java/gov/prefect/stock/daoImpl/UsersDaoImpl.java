package gov.prefect.stock.daoImpl;

import org.springframework.stereotype.Component;

import gov.prefect.security.entities.User;
import gov.prefect.stock.dao.IUsersDao;

@Component
public class UsersDaoImpl extends GenericDaoImpl<User> implements IUsersDao {

}
