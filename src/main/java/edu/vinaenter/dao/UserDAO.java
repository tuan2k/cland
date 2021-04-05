package edu.vinaenter.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.User;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> getList() throws ParseException {
		String sql = "select * from users";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}

	public User getById(int id) {
		String sql = "select * from users where id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), new Object[] { id });// id thoi
	}

	public int save(User user) {
		String sql = "insert into users(username,fullname,password) values (?,?,?)";
		return jdbcTemplate.update(sql, user.getUsername(), user.getFullname(), user.getPassword());
	}
	
	public int edit(User user) {
		String sql = "update users set username= ?, password =?, fullname=? where id = ?";
		return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFullname(),user.getId());
	}

	public int deleteById(int id) {
		String sql = "delete from users where id = ?";
		return jdbcTemplate.update(sql, id);
	}
}
