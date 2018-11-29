package gov.prefect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
	
	@ResponseBody
	@RequestMapping(value="/hello")
	public String index() {
		return "hello from Spring" ;
	}
	
	
	@RequestMapping(value="/home")
	public String home() {
		return"views/stock/home";
	}
	@RequestMapping(value="/deny")
	public String deny() {
		return"deny";
	}
	
	
	
	
	
	
	
}
