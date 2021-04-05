package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.vinaenter.dao.ContactDAO;
import edu.vinaenter.models.Contact;

@Repository
public class ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public List<Contact> getList() throws ParseException {
		List<Contact> list = contactDAO.getList();
		return list;
	}

	public Contact getById(int id) {
		return contactDAO.getById(id);
	}

	public int save(Contact contact) {
		return contactDAO.save(contact);
	}
	
	public int edit(Contact contact) {
		return contactDAO.edit(contact);
	}

	public int deleteById(int id) {
		return contactDAO.deleteById(id);
	}
}
