package edu.vinaenter.controllers.admin;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.contant.GlobalContant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;
import edu.vinaenter.services.CategoryService;
import edu.vinaenter.services.LandService;
import edu.vinaenter.util.FileUtil;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping("admin/land")
public class AdminIndexLandController {
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private CategoryService categoryService;
	
	//devide page
	@GetMapping({"index","index/{page}"})
	public String index(Model model,@PathVariable(required = false) Integer page) throws ParseException {
		// pageutil.getoffset
		if ( page == null) {
			page = 1;
		}
		List<Land> test = null;
		test = landService.getAll(PageUtil.getOffset(page), GlobalContant.TOTAL_PAGE);
		int totalPage = PageUtil.getTotalRow(landService.totalRow());
		model.addAttribute("listlands", test);
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPage",totalPage);
		return "admin.land.index";
	}

	@GetMapping("add")
	public String add(Model model) {
		List<Category> listcats = categoryService.getList();
		model.addAttribute("listcats", listcats);
		return "admin.land.add";
	}

	@PostMapping("add") // can't set name if the name is the same in form
	public String add(@Valid @ModelAttribute("land") Land land,@ModelAttribute("category") Category cat ,BindingResult rs
			,@RequestParam("image") MultipartFile image, RedirectAttributes msg, HttpServletRequest HttpServletRequest) {
		// set name model attribute to get in add.jsp
		// insert into db
		Category c = categoryService.getById(cat.getCid());
		land.setCategory(c);
		String fileName = FileUtil.upload(image,HttpServletRequest );
		// get fileName to insert db
		land.setPicture(fileName);
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.land.add";
		}
		Land l = null;
		l = landService.findOne(land);
		int save = 0;
		if (l == null) {
			 System.out.println("success");
			 save = landService.save(land);
		}
		if (save > 0) {
			msg.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.ENGLISH));
			return "redirect:/admin/land/index";
		}
		msg.addFlashAttribute("msg",messageSource.getMessage("msg.exist", null, Locale.ENGLISH));
		return "redirect:/admin/land/add";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Land land = landService.getById(id);
		model.addAttribute("land",land);
		List<Category> listcats = categoryService.getList();
		model.addAttribute("listcats", listcats);
		return "admin.land.edit";
	}
	
	@PostMapping("edit") // can't set name if the name is the same in form
	public String edit(@Valid @ModelAttribute("land") Land land,@ModelAttribute("category") Category cat ,BindingResult rs
			,@RequestParam("image") MultipartFile image, RedirectAttributes msg, HttpServletRequest HttpServletRequest) {
		Category c = categoryService.getById(cat.getCid());
		Land lold = landService.getById(land.getLid());
		land.setCategory(c);
		if (image == null) {
			land.setPicture(lold.getPicture());
		}else {
			String fileName = FileUtil.upload(image,HttpServletRequest );
			// get fileName to insert db
			land.setPicture(fileName);
		}
		if (rs.hasErrors()) {
			System.out.println("Có lỗi dữ liệu");
			return "admin.land.add";
		}
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
		msg.addFlashAttribute("msg",messageSource.getMessage("msg.exist", null, Locale.ENGLISH));
		return "redirect:/admin/land/edit"+land.getLid();
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
