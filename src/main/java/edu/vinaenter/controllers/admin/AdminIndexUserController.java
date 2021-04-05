package edu.vinaenter.controllers.admin;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.models.User;
import edu.vinaenter.services.UserService;

@Controller
@RequestMapping("admin/user")
public class AdminIndexUserController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(AdminIndexUserController.class);
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("index")
	public String index(Model model) {
		logger.info("this is log");
		List<User> listusesrs = null;
		try {
			listusesrs = userService.getList();
			model.addAttribute("listusers", listusesrs);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admin.userindex";
	}

	@GetMapping("add")
	public String add() {
		return "admin.useradd";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("user",user);
		return "admin.useredit";
	}
	
	@PostMapping("edit-model") // can't set name if the name is the same in form
	public String edit(@Valid @ModelAttribute("user") User user, BindingResult rs
			, RedirectAttributes msg) {
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.useredit";
		}
		int save = userService.edit(user);
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/user/index";
		}
		return "admin.useredit";
	}

	
	@PostMapping("add") // can't set name if the name is the same in form
	public String add(@Valid @RequestParam("name") String name, @RequestParam("createDate") String createDate) {
		System.out.println(name);
		System.out.println(createDate);
		return "add";
	}

	@PostMapping("add-model") // can't set name if the name is the same in form
	public String add(@Valid @ModelAttribute("user") User user, BindingResult rs
			, RedirectAttributes msg) {
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.useradd";
		}
		int save = userService.save(user);
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/user/index";
		}
		return "admin.useradd";
	}
	
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Integer id,Model model) {
		System.out.println("detail id:"+id);
		User user = userService.getById(id);
		model.addAttribute("user",user);
		return "admin.detail";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id,Model model
			, RedirectAttributes msg) {
		int delete = userService.deleteById(id);
		if (delete > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/user/index";
		}
		return "admin.index";
	}

}
