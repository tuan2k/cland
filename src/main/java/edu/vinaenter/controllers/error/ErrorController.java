package edu.vinaenter.controllers.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.contant.URLConstant;

@Controller
@RequestMapping(URLConstant.ERROR)
public class ErrorController {
	
	@GetMapping(URLConstant.STATUS_403)
	public String error403() {
		return "error.403";
	}

}
