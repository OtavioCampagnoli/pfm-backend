package com.pfm.api.service;

import java.util.List;

public interface IBaseService<T> {

	T save(T model);

	T update(T model);

	T paginatedSearch(T model);

	List<T> search(T model);

	T saveOrUpdate(T model);

	Boolean deleteById(Integer id);

	T getById(Integer id);

	List<T> findAll();

}
