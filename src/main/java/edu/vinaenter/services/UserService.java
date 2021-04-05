package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.UserDAO;
import edu.vinaenter.models.User;

@Service
public class UserService {
	
	@Autowired // DI
	private UserDAO userDAO;
	
	public List<User> getList() throws ParseException{
		List<User> list =userDAO.getList();
		return list;
	}
	
	public User getById(int id) {
		return userDAO.getById(id);
	}
	
	public int save(User user) {
		return userDAO.save(user);
	}
	
	public int edit(User user) {
		return userDAO.edit(user);
	}
	
	public int deleteById(int id) {
		return userDAO.deleteById(id);
	}

}
