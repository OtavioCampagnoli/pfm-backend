package com.pfm.core.service;


import com.pfm.core.model.ClassifierModel;

import java.util.List;

public interface IClassifierService extends IBaseService<ClassifierModel> {
	List<ClassifierModel> findAllByType(ClassifierModel model) throws Exception;
}
