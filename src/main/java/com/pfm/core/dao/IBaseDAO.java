package com.pfm.core.dao;

import java.util.List;

public interface IBaseDAO<T> {
	
	T save(T model) throws Exception;

	List<T> paginatedSearch(T model, int page, int size, String sortBy, int sortDirection) throws Exception;

	List<T> search(T model) throws Exception;

	T update(T model) throws Exception;

	Boolean deleteById(Integer id) throws Exception;

	T getById(Integer id) throws Exception;

	List<T> findAll() throws Exception;
}
