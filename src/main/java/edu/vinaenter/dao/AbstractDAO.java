package edu.vinaenter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAO<T> {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public List<T> getALL() {
		return null;
	}

	public int update(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int save(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public T findOne(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
