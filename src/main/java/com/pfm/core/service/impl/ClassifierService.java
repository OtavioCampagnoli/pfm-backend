package com.pfm.core.service.impl;

import com.pfm.core.dao.IClassifierDAO;
import com.pfm.core.model.ClassifierModel;
import com.pfm.core.service.IClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassifierService implements IClassifierService {

	@Autowired
	private IClassifierDAO dao;

	@Override
	public ClassifierModel save(ClassifierModel model) throws Exception {
		return dao.save(model);
	}

	@Override
	public ClassifierModel update(ClassifierModel model) throws Exception {
		return dao.update(model);
	}

	@Override
	public List<ClassifierModel> paginatedSearch(ClassifierModel model, int page, int size, String sortBy,
			int sortDirection) throws Exception {
		return dao.paginatedSearch(model, page, size, sortBy, sortDirection);
	}

	@Override
	public List<ClassifierModel> search(ClassifierModel model) throws Exception {
		return dao.search(model);
	}

	@Override
	public ClassifierModel saveOrUpdate(ClassifierModel model) throws Exception {
		return model.getId() == null ? this.save(model) : this.update(model);
	}

	@Override
	public Boolean deleteById(Integer id) throws Exception {
		return dao.deleteById(id);
	}

	@Override
	public ClassifierModel getById(Integer id) throws Exception {
		return dao.getById(id);
	}

	@Override
	public List<ClassifierModel> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public List<ClassifierModel> findAllByType(ClassifierModel model) throws Exception {
		return dao.findAllByType(model);
	}

}
