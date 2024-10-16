package com.pfm.transaction.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfm.transaction.dao.ITransactionDAO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.model.TransactionModel;
import com.pfm.transaction.service.ITransactionService;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	ITransactionDAO dao;

	@Override
	public TransactionModel save(TransactionModel model) {
		return this.dao.save(model);
	}

	@Override
	public TransactionModel update(TransactionModel model) {
		return this.dao.update(model);
	}

	@Override
	public TransactionModel saveOrUpdate(TransactionModel model) {

		if (model == null) {
			throw new IllegalArgumentException("Transaction model cannot be null");
		}

		if (model.getId() != null && model.getId() > 0) {
			return this.update(model);
		}

		return this.save(model);
	}

	@Override
	public Boolean deleteById(Integer id) {

		TransactionModel objectExistent = this.dao.getById(id);

		if (objectExistent != null) {
			if (objectExistent.getId() != null && objectExistent.getId() > 0) {
				return this.dao.deleteById(id);
			}
		}
		return false;
	}

	@Override
	public TransactionModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public List<TransactionModel> findAll() {
		return this.dao.findAll();
	}

	@Override
	public TransactionModel paginatedSearch(TransactionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionModel> search(TransactionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionModel> search(TransactionSearchDTO dto) {
		return this.dao.search(dto);
	}

}
