package com.pfm.api.transaction.service;

import java.util.List;

import com.pfm.api.service.IBaseService;
import com.pfm.api.transaction.dto.TransactionSearchDTO;
import com.pfm.api.transaction.model.TransactionModel;

public interface ITransactionService extends IBaseService<TransactionModel> {

	List<TransactionModel> search(TransactionSearchDTO dto);
	
}
