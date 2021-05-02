package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

	public Contact validateContact(Contact contact) {
		String sql = "select * from vnecontact where fullname =? and email= ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>(){
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Contact c = new Contact();
				if(rs.next()) {
					c.setCid(rs.getInt("cid"));
					c.setFullname(rs.getString("fullname"));
					c.setEmail(rs.getString("email"));
					c.setSubject(rs.getString("subject"));
					c.setContent(rs.getString("content"));
				}else {
					c =  null;
				}
				return c;
			}
		},contact.getFullname(),contact.getEmail());
	}

	public Contact validateUpdate(@Valid Contact contact) {
		String sql = "select * from vnecontact where fullname =? and email= ? and cid != ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>(){
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Contact c = new Contact();
				if(rs.next()) {
					c.setCid(rs.getInt("cid"));
					c.setFullname(rs.getString("fullname"));
					c.setEmail(rs.getString("email"));
					c.setSubject(rs.getString("subject"));
					c.setContent(rs.getString("content"));
				}else {
					c =  null;
				}
				return c;
			}
		},contact.getFullname(),contact.getEmail(), contact.getCid());
	}

	public List<Contact> getBySearch(String search) {
		String sql = "SELECT * FROM vnecontact where fullname like '%"+search+"%'"
				+ " or fullname like '%"+search+"%'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class));
	}
}
