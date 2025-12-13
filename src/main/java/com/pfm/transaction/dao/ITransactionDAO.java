package com.pfm.transaction.dao;

import java.util.List;

import com.pfm.core.dao.IBaseDAO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.model.TransactionModel;

public interface ITransactionDAO extends IBaseDAO<TransactionModel>  {

	List<TransactionModel> search(TransactionSearchDTO dto);

}
