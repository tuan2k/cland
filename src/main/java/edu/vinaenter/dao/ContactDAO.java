package edu.vinaenter.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Contact;

@Repository
public class ContactDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Contact> getList() throws ParseException {
		String sql = "select * from vnecontact";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class));
	}

	public Contact getById(int id) {
		String sql = "select * from vnecontact where cid = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Contact.class), new Object[] { id });// id
																													// thoi
	}

	public int save(Contact contact) {
		String sql = "insert into vnecontact(fullname,email,subject,content) values (?,?,?,?)";
		return jdbcTemplate.update(sql, contact.getFullname(), contact.getEmail(), contact.getSubject(),
				contact.getContent());
	}
	
	public int edit(Contact contact) {
		String sql = "update vnecontact set fullname= ?, email = ?, subject= ?, content= ? where cid =? ";
		return jdbcTemplate.update(sql, contact.getFullname(),contact.getEmail(),contact.getSubject(),
				contact.getContent(),contact.getCid());
	}

	public int deleteById(int id) {
		String sql = "delete from vnecontact where cid = ?";
		return jdbcTemplate.update(sql, id);
	}

}
