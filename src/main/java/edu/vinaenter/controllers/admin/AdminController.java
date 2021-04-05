package edu.vinaenter.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@GetMapping("/index")
	public String index() {
		return "admin.index";
	}
	
	@GetMapping("/cat")
	public String cat() {
		return "admin.cat";
	}
	
	@GetMapping("/add")
	public String add() {
		return "admin.add";
	}
	
	@GetMapping("/news")
	public String news() {
		return "admin.news";
	}
	
	@GetMapping("/login")
	public String login() {
		return "admin.login";
	}

}
