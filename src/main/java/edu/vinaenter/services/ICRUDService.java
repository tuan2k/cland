package edu.vinaenter.services;

import java.util.List;

public interface ICRUDService<T> {
	
	List<T> getList();
	
	int edit(T t);
	
	int save(T t);
	
	int deleteById(int id);
	
	T findOne(T t);
	
	T getById(int id);

}
