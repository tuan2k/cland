package edu.vinaenter.controllers.admin;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.models.Contact;
import edu.vinaenter.services.ContactService;

@Controller
@RequestMapping("admin/contact")
public class AdminIndexContactController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(AdminIndexContactController.class);
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("index")
	public String index(Model model) {
		logger.info("this is log");
		List<Contact> listcontacts = null;
		listcontacts = contactService.getList();
		model.addAttribute("listcontacts", listcontacts);
		return "admin.contact.index";
	}

	@GetMapping("add")
	public String add() {
		return "admin.contact.add";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Contact contact = contactService.getById(id);
		model.addAttribute("contact",contact);
		return "admin.contact.edit";
	}
	
	@PostMapping("edit") // can't set name if the name is the same in form
	public String edit(@Valid @ModelAttribute("contact") Contact contact, BindingResult rs
			, RedirectAttributes msg) {
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.contact.edit";
		}
		int save = contactService.edit(contact);
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/contact/index";
		}
		return "admin.contact.edit";
	}


	@PostMapping("add") // can't set name if the name is the same in form
	public String add(@Valid @ModelAttribute("contact") Contact contact, BindingResult rs
			, RedirectAttributes msg) {
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.contact.add";
		}
		int save = contactService.save(contact);
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/contact/index";
		}
		return "admin.contact.add";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id,Model model
			, RedirectAttributes msg) {
		int delete = contactService.deleteById(id);
		if (delete > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/contact/index";
		}
		return "admin.contact.index";
	}

}
