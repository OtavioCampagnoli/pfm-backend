package com.pfm.core.dao;

import com.pfm.core.model.ClassifierModel;

import java.util.List;

public interface IClassifierDAO extends IBaseDAO<ClassifierModel> {
	
	List<ClassifierModel> findAllByType(ClassifierModel model) throws Exception;
}
