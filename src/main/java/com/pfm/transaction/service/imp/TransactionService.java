package com.pfm.transaction.service.imp;

import com.pfm.core.model.ClassifierModel;
import com.pfm.core.service.IClassifierService;
import com.pfm.transaction.dao.ITransactionDAO;
import com.pfm.transaction.dto.TransactionResponseDTO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.model.TransactionModel;
import com.pfm.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

	private final ITransactionDAO dao;
	private final IClassifierService classifierService;

	@Autowired
	TransactionService(
			ITransactionDAO dao,
			IClassifierService classifierService
	) {
		this.dao = dao;
		this.classifierService = classifierService;
	}

	@Override
	public TransactionModel save(TransactionModel model) throws Exception {
		return this.dao.save(model);
	}

	@Override
	public TransactionModel update(TransactionModel model) throws Exception {
		return this.dao.update(model);
	}

	@Override
	public List<TransactionModel> paginatedSearch(TransactionModel model, int page, int size, String sortBy, int sortDirection) throws Exception {
		return List.of();
	}

	@Override
	public List<TransactionModel> search(TransactionModel model) throws Exception {
		return List.of();
	}

	@Override
	public TransactionModel saveOrUpdate(TransactionModel model) throws Exception {

		if (model == null) {
			throw new IllegalArgumentException("Transaction model cannot be null");
		}

		if (model.getId() != null && model.getId() > 0) {
			return this.update(model);
		}

		return this.save(model);
	}

	@Override
	public Boolean deleteById(Integer id) throws Exception {

		TransactionModel objectExistent = this.dao.getById(id);

		if (objectExistent != null) {
			if (objectExistent.getId() != null && objectExistent.getId() > 0) {
				return this.dao.deleteById(id);
			}
		}
		return false;
	}

	@Override
	public TransactionModel getById(Integer id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public List<TransactionModel> findAll() throws Exception {
		List<TransactionModel> transactions = this.dao.findAll();

		transactions.stream()
				.forEach(tra -> {
                    try {
                      ClassifierModel categoryCla = this.classifierService.getById(tra.getCategoryCla().getId());
					  tra.setCategoryCla(categoryCla);
					  ClassifierModel typeCla = this.classifierService.getById(tra.getTypeCla().getId());
					  tra.setTypeCla(typeCla);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
		return transactions;
	}

	@Override
	public List<TransactionModel> search(TransactionSearchDTO dto) {
		return this.dao.search(dto);
	}

}
