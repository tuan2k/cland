package edu.vinaenter.controllers.cland;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ClandController {
	
	@GetMapping("/index")
	public String index() {
		return "cland.index";
	}
	
	@GetMapping("/cat")
	public String cat() {
		return "cland.cat";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "cland.contact";
	}
	
	@GetMapping("/single")
	public String single() {
		return "cland.single";
	}

}
