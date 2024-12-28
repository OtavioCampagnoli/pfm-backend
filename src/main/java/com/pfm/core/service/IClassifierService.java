package com.pfm.core.service;


import com.pfm.core.dto.ClassifierSaveRequestDTO;
import com.pfm.core.dto.ClassifierSearchRequestDTO;
import com.pfm.core.model.ClassifierModel;

import java.util.List;

public interface IClassifierService extends IBaseService<ClassifierModel> {

	ClassifierModel convertClassifierSaveRequestDTOToClassifierModel(ClassifierSaveRequestDTO dto);

	ClassifierModel convertClassifierSearchRequestDTOToClassifierModel(ClassifierSearchRequestDTO dto);

	List<ClassifierModel> findAllByType(ClassifierModel model) throws Exception;

}
