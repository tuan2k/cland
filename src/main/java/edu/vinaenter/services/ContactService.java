package edu.vinaenter.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.vinaenter.dao.ContactDAO;
import edu.vinaenter.models.Contact;

@Repository
public class ContactService implements ICRUDService<Contact> {

	@Autowired
	private ContactDAO contactDAO;

	public List<Contact> getList() {
		List<Contact> list=null;
		try {
			list = contactDAO.getList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public Contact findOne(Contact t) {
		// TODO Auto-generated method stub
		return null;
	}
}
