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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.models.Land;
import edu.vinaenter.services.LandService;

@Controller
@RequestMapping("admin/land")
public class AdminIndexLandController {
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private LandService landService;
	
	@GetMapping("index")
	public String index(Model model) {
		List<Land> listlands = null;
		try {
			listlands = landService.getList();
			model.addAttribute("listlands", listlands);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admin.news";
	}

	@GetMapping("add")
	public String add() {
		return "admin.landadd";
	}

	@PostMapping("add") // can't set name if the name is the same in form
	public String add(@Valid @RequestParam("name") String name, @RequestParam("createDate") String createDate) {
		System.out.println(name);
		System.out.println(createDate);
		return "admin.landadd";
	}

	@PostMapping("add-model") // can't set name if the name is the same in form
	public String add(@Valid @ModelAttribute("user") Land land, BindingResult rs
			, RedirectAttributes msg) {
		// set name model attribute to get in add.jsp
		// insert into db
		//String fileName = FileUtil.upload(football.getPictures());
		// get fileName to insert db
		//System.out.println(fileName);
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "add";
		}
		int save = landService.save(land);
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/land/index";
		}
		return "admin.landadd";
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
		return "admin.landindex";
	}

}
