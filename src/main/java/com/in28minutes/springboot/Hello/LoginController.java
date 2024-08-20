package com.in28minutes.springboot.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	private AuthenticationService authenticationService;
	
	
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value = "login",method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";	
	}
	
	@RequestMapping(value = "login",method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
	
		if(authenticationService.authenticate(name, password)) {
			//model.put("password", password);
			model.put("name", name);
			return "welcome";	
		}
		model.put("errorMessage", "invalid Credentials! please try again");
		return "login";
	}
}
