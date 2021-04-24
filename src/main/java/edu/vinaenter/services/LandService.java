package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.LandDAO;
import edu.vinaenter.models.Land;

@Service
public class LandService implements ICRUDService<Land> {
	
	@Autowired // DI
	private LandDAO landDAO;
	
	public List<Land> getList() {
		List<Land> list=null;
		try {
			list = landDAO.getList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Land> getAll(int offset,int currentpage){
		List<Land> list=null;
		try {
			list = landDAO.getAll(offset, currentpage);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Land getById(int id) {
		return landDAO.getById(id);
	}
	
	public List<Land> getByCategoryId(int id) {
		return landDAO.getByCategoryId(id);
	}
	
	public int save(Land land) {
		return landDAO.save(land);
	}
	
	public int deleteById(int id) {
		return landDAO.deleteById(id);
	}

	@Override
	public int edit(Land t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Land findOne(Land t) {
		return landDAO.findOne(t);
	}

	public int totalRow() {
		return landDAO.totalRow();
	}

	public List<Land> getBySearch(String search) {
		return landDAO.getBySearch(search);
	}
}
