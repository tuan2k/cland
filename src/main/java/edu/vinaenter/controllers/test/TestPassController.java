package edu.vinaenter.controllers.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestPassController {
	
	@Autowired
	private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder BCryptPasswordEncoder;
	
	@GetMapping("create-pass")
	@ResponseBody
	public String index() {
		return BCryptPasswordEncoder.encode("123456");
	}

}
