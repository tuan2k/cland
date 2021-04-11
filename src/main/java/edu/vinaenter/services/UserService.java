package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.UserDAO;
import edu.vinaenter.models.User;

@Service
public class UserService implements ICRUDService<User> {
	
	@Autowired // DI
	private UserDAO userDAO;
	
	public List<User> getList() {
		List<User> list=null;
		try {
			list = userDAO.getList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public User findOne(User t) {
		return userDAO.findOne(t);
	}

}
