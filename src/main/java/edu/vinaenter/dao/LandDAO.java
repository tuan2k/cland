package edu.vinaenter.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Land;

@Repository
public class LandDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Land> getList() throws ParseException {
		String sql = "select * from lands";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Land.class));
	}

	public Land getById(int id) {
		String sql = "select * from lands where id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Land.class), new Object[] { id });// id thoi
	}

	public int save(Land land) {
		String sql = "insert into lands(lname,description,date_create,cid,picture,area,address,cout_views) values (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,land.getLname(), land.getDescription(),land.getDate(),land.getCat_id(),land.getPicture()
				,land.getArea(), land.getAddress(),land.getCount_views());
	}
	
	public int deleteById(int id) {
		String sql = "delete from lands where id = ?";
		return jdbcTemplate.update(sql, id);
	}

}
