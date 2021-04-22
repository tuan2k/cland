package edu.vinaenter.controllers.auth;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Resource
	MessageSource messageSource; 
	
	@GetMapping("login")
	public String login() {
		return "admin.auth.login";
	}
	
		
}
