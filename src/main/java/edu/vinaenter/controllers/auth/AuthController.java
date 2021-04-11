package edu.vinaenter.controllers.auth;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.models.User;
import edu.vinaenter.services.UserService;

@Controller
@RequestMapping("admin/auth")
public class AuthController {
	
	
	@Autowired
	private UserService userService;
	
	@Resource
	MessageSource messageSource; 
	
	@GetMapping("login")
	public String login() {
		return "admin.auth.login";
	}
	
	@PostMapping("login")
	public String login(@ModelAttribute("user") User user, BindingResult rs, RedirectAttributes msg) {
		User u =null;
		u = userService.findOne(user);
		System.out.println("vo controller");
		if (u != null) {
			System.out.println();
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/user/index";
		}
		return "admin.auth.login";
	}
	
	
}
