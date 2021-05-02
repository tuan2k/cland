package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;

@Repository
public class LandDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public List<Land> getList() throws ParseException {
		String sql = "SELECT * FROM lands l INNER JOIN categories c on l.cid = c.cid";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Land>>() {
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Land> listlands = new ArrayList<Land>();
				while(rs.next()) {
					Land land  = new Land();
					Category cat = new Category();
					land.setLid(rs.getInt("lid"));;
					land.setLname(rs.getString("lname"));
					land.setAddress(rs.getString("address"));
					land.setDescription(rs.getString("description"));
					land.setPicture(rs.getString("picture"));
					land.setCount_views(rs.getInt("count_views"));
					land.setDate(rs.getString("date_create"));
					land.setArea(rs.getInt("area"));
					cat.setCid(rs.getInt("cid"));
					cat.setCname(rs.getString("cname"));
					land.setCategory(cat);
					listlands.add(land);
					land = null;
					cat = null;
				}
				return listlands;
			}
		});	
				
	}
	
	public List<Land> getAll(int offset, int currentpage) throws ParseException {
		String sql = "SELECT * FROM lands l INNER JOIN categories c on l.cid = c.cid limit ?,?";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Land>>() {
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Land> listlands = new ArrayList<Land>();
				while(rs.next()) {
					Land land  = new Land();
					Category cat = new Category();
					land.setLid(rs.getInt("lid"));;
					land.setLname(rs.getString("lname"));
					land.setAddress(rs.getString("address"));
					land.setDescription(rs.getString("description"));
					land.setPicture(rs.getString("picture"));
					land.setCount_views(rs.getInt("count_views"));
					land.setDate(rs.getString("date_create"));
					land.setArea(rs.getInt("area"));
					cat.setCid(rs.getInt("cid"));
					cat.setCname(rs.getString("cname"));
					land.setCategory(cat);
					listlands.add(land);
					land = null;
					cat = null;
				}
				return listlands;
			}
		},offset,currentpage);	
				
	}
	
	public int totalRow() {
		String sql = "select count(*) as count from lands l  INNER JOIN categories c on l.cid= c.cid";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public int totalRowSearch(String search) {
		String sql = "select count(*) as count from lands l  INNER JOIN categories c on l.cid= c.cid where l.lname like '%"
				+search+"%'"+"or l.description like '%"+search+"%'";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public Land getById(int id) {
		String sql = "SELECT * FROM lands l INNER JOIN categories c on l.cid = c.cid where l.lid = ?";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Land>() {
			@Override
			public Land extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Land land = new Land();
				if(rs.next()) {
					Category cat = new Category();
					land.setLid(rs.getInt("lid"));;
					land.setLname(rs.getString("lname"));
					land.setAddress(rs.getString("address"));
					land.setDescription(rs.getString("description"));
					land.setPicture(rs.getString("picture"));
					land.setCount_views(rs.getInt("count_views"));
					land.setDate(rs.getString("date_create"));
					land.setArea(rs.getInt("area"));
					cat.setCid(rs.getInt("cid"));
					cat.setCname(rs.getString("cname"));
					land.setCategory(cat);
				}
				return land;
			}
		},id);	
	}
	
	
	public List<Land> getByCategoryId(int cid) {
		String sql = "SELECT * FROM lands l INNER JOIN categories c on l.cid = c.cid where l.cid = ?";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Land>>() {
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Land> listlands = new ArrayList<Land>();
				while(rs.next()) {
					Land land  = new Land();
					Category cat = new Category();
					land.setLid(rs.getInt("lid"));;
					land.setLname(rs.getString("lname"));
					land.setAddress(rs.getString("address"));
					land.setDescription(rs.getString("description"));
					land.setPicture(rs.getString("picture"));
					land.setCount_views(rs.getInt("count_views"));
					land.setDate(rs.getString("date_create"));
					land.setArea(rs.getInt("area"));
					cat.setCid(rs.getInt("cid"));
					cat.setCname(rs.getString("cname"));
					land.setCategory(cat);
					listlands.add(land);
					land = null;
					cat = null;
				}
				return listlands;
			}
		},cid);	
	}

	public int save(Land land) {
		String sql = "insert into lands(lname,description,cid,picture,area,address,count_views) values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,land.getLname(), land.getDescription(),land.getCategory().getCid(),land.getPicture()
				,land.getArea(), land.getAddress(),land.getCount_views());
	}
	
	public int deleteById(int id) {
		String sql = "delete from lands where lid = ?";
		return jdbcTemplate.update(sql, id);
	}

	public List<Land> getBySearch(String search,int offset, int totalPage) {
		String sql = "SELECT * FROM lands l INNER JOIN categories c on l.cid = c.cid where l.lname like '%"+search+"%'"
				+ " or l.description like '%"+search+"%' limit ?,?";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Land>>() {
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Land> listlands = new ArrayList<Land>();
				while(rs.next()) {
					Land land  = new Land();
					Category cat = new Category();
					land.setLid(rs.getInt("lid"));;
					land.setLname(rs.getString("lname"));
					land.setAddress(rs.getString("address"));
					land.setDescription(rs.getString("description"));
					land.setPicture(rs.getString("picture"));
					land.setCount_views(rs.getInt("count_views"));
					land.setDate(rs.getString("date_create"));
					land.setArea(rs.getInt("area"));
					cat.setCid(rs.getInt("cid"));
					cat.setCname(rs.getString("cname"));
					land.setCategory(cat);
					listlands.add(land);
					land = null;
					cat = null;
				}
				return listlands;
			}
		},offset,totalPage);	
	}
	
	public Land findOne(Land land) {
		String sql = "SELECT * FROM lands l INNER JOIN categories c on l.cid = c.cid where l.lname = ? and l.lid != ?";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Land>() {
			@Override
			public Land extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Land land = new Land();
				if(rs.next()) {
					Category cat = new Category();
					land.setLid(rs.getInt("lid"));;
					land.setLname(rs.getString("lname"));
					land.setAddress(rs.getString("address"));
					land.setDescription(rs.getString("description"));
					land.setPicture(rs.getString("picture"));
					land.setCount_views(rs.getInt("count_views"));
					land.setDate(rs.getString("date_create"));
					land.setArea(rs.getInt("area"));
					cat.setCid(rs.getInt("cid"));
					cat.setCname(rs.getString("cname"));
					land.setCategory(cat);
				}else {
					land = null;
				}
				return land;
			}
		},land.getLname(),land.getLid());	
	}

	public int edit(Land t) {
		String sql = "update lands set lname= ?, address =?, description=?,"
				+ " picture=?, count_views =?, area=?, cid=?  where lid = ?";
		return jdbcTemplate.update(sql,t.getLname(), t.getAddress(),t.getDescription(),t.getPicture(), t.getCount_views(),
			t.getArea(),t.getCategory().getCid(),t.getLid());
	}

}
