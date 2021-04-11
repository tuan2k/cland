package edu.vinaenter.controllers.admin;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

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
import edu.vinaenter.models.Land;
import edu.vinaenter.services.CategoryService;
import edu.vinaenter.services.LandService;
import edu.vinaenter.util.FileUtil;

@Controller
@RequestMapping("admin/land")
public class AdminIndexLandController {
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("index")
	public String index(Model model) throws ParseException {
		List<Land> listlands = null;
		listlands = landService.getList();
		if (listlands.size() == 0) System.out.println("null");
		model.addAttribute("listlands", listlands);
		return "admin.land.index";
	}

	@GetMapping("add")
	public String add(Model model) {
		List<Category> listcats = categoryService.getList();
		model.addAttribute("listcats", listcats);
		return "admin.land.add";
	}

	@PostMapping("add") // can't set name if the name is the same in form
	public String add(@Valid @ModelAttribute("land") Land land,@ModelAttribute("category") Category cat , BindingResult rs
			, RedirectAttributes msg) {
		// set name model attribute to get in add.jsp
		// insert into db
		Category c = categoryService.getById(cat.getCid());
		land.setCategory(c);
		String fileName = FileUtil.upload(land.getPicture());
		// get fileName to insert db
		land.setPictures(fileName);
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.land.add";
		}
		int save = landService.save(land);
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/land/index";
		}
		return "admin.land.add";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Land land = landService.getById(id);
		model.addAttribute("land",land);
		return "admin.land.edit";
	}
	
	@PostMapping("edit") // can't set name if the name is the same in form
	public String edit(@Valid @ModelAttribute("land") Land land, BindingResult rs
			, RedirectAttributes msg) {
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.land.edit";
		}
		Land l = landService.findOne(land);
		int save = 0;
		if (l == null) {
			save = landService.edit(land);
		}
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/land/index";
		}
		return "admin.land.edit";
	}
	
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Integer id,Model model) {
		System.out.println("detail id:"+id);
		Land land = landService.getById(id);
		model.addAttribute("land",land);
		return "admin.landdetail";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id,Model model
			, RedirectAttributes msg) {
		int delete = landService.deleteById(id);
		if (delete > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/land/index";
		}
		return "admin.land.index";
	}

}
