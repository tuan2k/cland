package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CatDAO;
import edu.vinaenter.models.Category;

@Service
public class CategoryService implements ICRUDService<Category> {
	
	@Autowired
	private CatDAO catDAO;

	public List<Category> getList() {
		List<Category> list=null;
		try {
			list = catDAO.getList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public Category findOne(Category t) {
		return catDAO.findOne(t);
	}
}
