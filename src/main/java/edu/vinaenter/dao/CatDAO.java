package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Category;

@Repository
public class CatDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Category> getList() throws ParseException {
		String sql = "select * from categories";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
	}

	public Category getById(int id) {
		String sql = "select * from categories where cid = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class), new Object[] { id });// id
																													
	}

	public int save(Category category) {
		String sql = "insert into categories(cname) values (?)";
		return jdbcTemplate.update(sql, category.getCname());
	}

	public int deleteById(int id) {
		String sql = "delete from categories where cid = ?";
		return jdbcTemplate.update(sql, id);
	}
	
	public int edit(Category cat) {
		String sql = "update categories set cname= ? where cid = ?";
		return jdbcTemplate.update(sql, cat.getCname(),cat.getCid());
	}
	
	public Category findOne(Category t) {
		String sql = "select * from categories where cname =?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Category>(){
			@Override
			public Category extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Category c = new Category();
				if(rs.next()) {
					c.setCid(rs.getInt("cid"));
					c.setCname(rs.getString("cname"));
				}else {
					c =  null;
				}
				return c;
			}
		},t.getCname());
	}

}
