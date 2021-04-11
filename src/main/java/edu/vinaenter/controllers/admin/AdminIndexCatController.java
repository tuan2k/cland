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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.contant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.services.CategoryService;

@Controller
@RequestMapping(value=URLConstant.URL_ADMIN_CAT)
public class AdminIndexCatController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(AdminIndexUserController.class);
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private CategoryService catService;
	
	@GetMapping(value = URLConstant.INDEX)
	public String index(Model model) {
		logger.info("this is log");
		List<Category> listcats = null;
		listcats = catService.getList();
		System.out.println(listcats.get(0).getCname());
		model.addAttribute("listcats", listcats);
		return "admin.catindex";
	}

	@GetMapping(value = URLConstant.ADD)
	public String add() {
		return "admin.catadd";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Category cat = catService.getById(id);
		model.addAttribute("cat",cat);
		return "admin.catedit";
	}
	
	@PostMapping("edit") // can't set name if the name is the same in form
	public String edit(@Valid @ModelAttribute("category") Category cat, BindingResult rs
			, RedirectAttributes msg) {
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.catedit";
		}
		Category c = null;
		int save = 0;
		c = catService.findOne(cat);
		if (c == null) {
			save = catService.edit(cat);
		}
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/cat/index";
		}
		msg.addFlashAttribute("msg",messageSource.getMessage("msg.faile", null, Locale.ENGLISH));
		return "admin.catindex";
	}

	
	@PostMapping(value = URLConstant.INDEX) // can't set name if the name is the same in form
	public String add(@Valid @RequestParam("name") String name, @RequestParam("createDate") String createDate) {
		System.out.println(name);
		System.out.println(createDate);
		return "add";
	}

	@PostMapping("add-model") // can't set name if the name is the same in form
	public String add(@Valid @ModelAttribute("cat") Category cat, BindingResult rs
			, RedirectAttributes msg) {
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.catadd";
		}
		Category c = null;
		int save = 0;
		c = catService.findOne(cat);
		if (c == null) {
			save = catService.save(cat);
		}
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/cat/index";
		}
		return "admin.catadd";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id,Model model
			, RedirectAttributes msg) {
		int delete = catService.deleteById(id);
		if (delete > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/cat/index";
		}
		return "admin.catindex";
	}

}
