package com.pfm.transaction.service;

import java.util.List;

import com.pfm.core.service.IBaseService;
import com.pfm.transaction.dto.TransactionSaveOrUpdateDTO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.model.TransactionModel;
import jakarta.validation.Valid;

public interface ITransactionService extends IBaseService<TransactionModel> {
	List<TransactionModel> search(TransactionSearchDTO dto);
	TransactionModel convertToModel(@Valid TransactionSaveOrUpdateDTO dto);
}
