package edu.vinaenter.services;

import java.util.List;

public interface ICRUDService<T> {
	
	List<T> getALL();
	
	int update(T t);
	
	int save(T t);
	
	int delete(int id);
	
	T findOne(T t);
	
	T findById(int id);

}
