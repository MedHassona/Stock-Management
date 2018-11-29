package gov.prefect.admin.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.prefect.security.entities.Role;
import gov.prefect.security.entities.User;
import gov.prefect.stock.services.IRoleService;
import gov.prefect.stock.services.IUsersService;

@Controller
@RequestMapping(value="/users")	
public class UsersController {

	@Autowired
	private IUsersService userService;
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value="/")	
	public String agents(Model model) {
		List<User> users = userService.selectAll();
		if(users == null) {
			users = new ArrayList<>();
		}
		
		
		model.addAttribute("agents", users);
		
		return "views/admin/users/users";
	}
	
	@RequestMapping(value="/nouveau", method = RequestMethod.GET)
	public String nouveau(Model model) {
		List<Role> roles = roleService.selectAll();
		User user = new User();
		if(roles == null)
			System.out.println("ROLES NULL");
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "views/admin/users/ajouterUser";
	}
	@RequestMapping(value="/nouveau",method = RequestMethod.POST)
	public String enrgistrerCategorie(Model model, User user) {
		List<Role> roles = roleService.selectAll("role", "DESC");
		List<Role> r = new ArrayList<>();
		
		if(user != null) {
			if(user.getRole().equals("cons")) {
				r.add(roles.get(1));
				user.setRoles(r);
			}else if(user.getRole().equals("admin")) {
				r.add(roles.get(0));
				r.add(roles.get(1));
				r.add(roles.get(2));
				user.setRoles(r);
			}else if(user.getRole().equals("agent")){
				r.add(roles.get(0));
				r.add(roles.get(1));
				user.setRoles(r);
			}
			user.setActive(true);
				
			userService.save(user);
		}
		
		return"redirect:/users/";
	}
}
