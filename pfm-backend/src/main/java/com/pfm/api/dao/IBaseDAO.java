package com.pfm.api.dao;

import java.util.List;

public interface IBaseDAO<T> {

	T save(T model);
	
	T paginatedSearch(T model);
	
	List<T> search(T model);
	
	T update(T model);

	Boolean deleteById(Integer id);

	T getById(Integer id);

	List<T> findAll();
	
}
