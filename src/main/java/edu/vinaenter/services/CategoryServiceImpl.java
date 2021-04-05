package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.vinaenter.dao.CatDAO;
import edu.vinaenter.models.Category;

public class CategoryServiceImpl implements ICRUDService<Category>{

	@Autowired
	private CatDAO catDAO;
	
	@Override
	public List<Category> getALL() {
		List<Category> list=null;
		try {
			list = catDAO.getList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category findOne(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
