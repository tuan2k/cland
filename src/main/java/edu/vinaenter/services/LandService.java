package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.LandDAO;
import edu.vinaenter.models.Land;

@Service
public class LandService {
	
	@Autowired // DI
	private LandDAO landDAO;
	
	public List<Land> getList() throws ParseException{
		List<Land> list =landDAO.getList();
		return list;
	}
	
	public Land getById(int id) {
		return landDAO.getById(id);
	}
	
	public int save(Land land) {
		return landDAO.save(land);
	}
	
	public int deleteById(int id) {
		return landDAO.deleteById(id);
	}

}
