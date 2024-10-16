package com.pfm.api.transaction.dao;

import java.util.List;

import com.pfm.api.dao.IBaseDAO;
import com.pfm.api.transaction.dto.TransactionSearchDTO;
import com.pfm.api.transaction.model.TransactionModel;

public interface ITransactionDAO extends IBaseDAO<TransactionModel>  {

	List<TransactionModel> search(TransactionSearchDTO dto);

}
