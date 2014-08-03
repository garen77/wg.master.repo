package com.wg.dao.api;

import java.util.List;

import com.wg.model.BaseModel;

public interface IGenericDao<T> {

	public T findByKey(int key);
	
	public List<T> findByCriteria(BaseModel criteria) throws IllegalArgumentException, IllegalAccessException ;
	
	public List<T> findAll();
}
