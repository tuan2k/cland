package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CatDAO;
import edu.vinaenter.models.Category;

@Service
public class CategoryService {
	
	
	@Autowired
	private CatDAO catDAO;

	public List<Category> getList() throws ParseException {
		List<Category> list = catDAO.getList();
		return list;
	}

	public Category getById(int id) {
		return catDAO.getById(id);
	}

	public int save(Category category) {
		return catDAO.save(category);
	}

	public int deleteById(int id) {
		return catDAO.deleteById(id);
	}

	public int edit(Category cat) {
		return catDAO.edit(cat);
	}
}
