package edu.vinaenter.controllers.cland;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

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

import edu.vinaenter.models.Category;
import edu.vinaenter.models.Contact;
import edu.vinaenter.models.Land;
import edu.vinaenter.services.CategoryService;
import edu.vinaenter.services.ContactService;
import edu.vinaenter.services.LandService;

@Controller
@RequestMapping("")
public class ClandController {
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private ContactService contactService;
	
	@Resource
	MessageSource messageSource;
	
	
	@GetMapping("/")
	public String index(Model model) {
		List<Land> listlands = new ArrayList<Land>();
		listlands = landService.getList();
		List<Category> listcats = new ArrayList<Category>();
		listcats = catService.getList();
		model.addAttribute("listcats",listcats);
		model.addAttribute("listlands",listlands);
		return "cland.index";
	}
	
	@GetMapping("/cat/{id}")
	public String cat(Model model,@PathVariable Integer id) {
		List<Land> listlands = landService.getByCategoryId(id);
		model.addAttribute("listlands",listlands);
		List<Category> listcats = new ArrayList<Category>();
		listcats = catService.getList();
		model.addAttribute("listcats",listcats);
		return "cland.cat";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		List<Category> listcats = new ArrayList<Category>();
		listcats = catService.getList();
		model.addAttribute("listcats",listcats);
		return "cland.contact";
	}
	
	@PostMapping("/contact")
	public String contact(Model model,@ModelAttribute("contact") Contact contact, 
			BindingResult rs,RedirectAttributes msg) {
		List<Category> listcats = new ArrayList<Category>();
		listcats = catService.getList();
		model.addAttribute("listcats",listcats);
		if (rs.hasErrors()) {
			System.out.println("có lỗi dữ liệu");
		}
		int save = contactService.save(contact);
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/contact";
		}
		return "cland.contact";
	}
	
	@GetMapping("/single/{id}")
	public String single(Model model,@PathVariable Integer id) {
		Land land = landService.getById(id);
		List<Land> listlands = new ArrayList<Land>();
		listlands = landService.getList();
		List<Category> listcats = new ArrayList<Category>();
		listcats = catService.getList();
		model.addAttribute("listcats",listcats);
		model.addAttribute("listlands",listlands);
		model.addAttribute("land",land);
		return "cland.single";
	}

}
