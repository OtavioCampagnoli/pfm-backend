package com.pfm.transaction.service.imp;

import com.pfm.core.service.IClassifierService;
import com.pfm.transaction.dao.ITransactionDAO;
import com.pfm.transaction.dto.TransactionResponseDTO;
import com.pfm.transaction.dto.TransactionSaveOrUpdateDTO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.model.TransactionModel;
import com.pfm.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
		return this.dao.findAll();
	}

	@Override
	public List<TransactionModel> search(TransactionSearchDTO dto) {
		return this.dao.search(dto);
	}

	@Override
	public TransactionModel convertToModel(TransactionSaveOrUpdateDTO dto) {
		TransactionModel model = new TransactionModel();

		if(Objects.nonNull(dto.getId())) {
			model.setId(dto.getId());
		}
		model.setDescription(dto.getDescription());
		model.setAmount(dto.getAmount());
		model.setTypeCla(dto.getTypeCla());
		model.setCategoryCla(dto.getCategoryCla());
		model.setDate(dto.getDate());

		return model;
	}

	@Override
	public List<TransactionResponseDTO> listAll() throws Exception {
		List<TransactionModel> models = this.findAll();
		return this.convertToResponseDTO(models);
	}

    @Override
	public List<TransactionResponseDTO> convertToResponseDTO(List<TransactionModel> models) throws Exception {
		List<TransactionResponseDTO> responseList = new LinkedList<>();
		for (TransactionModel model : models) {
			TransactionResponseDTO dto = convertSingleToResponseDTO(model);
			responseList.add(dto);
		}
		return responseList;
	}


	private TransactionResponseDTO convertSingleToResponseDTO(TransactionModel model) throws Exception {
		TransactionResponseDTO dto = new TransactionResponseDTO();
		dto.setId(model.getId());
		dto.setDescription(model.getDescription());
		dto.setAmount(model.getAmount());
		dto.setDate(model.getDate());
		dto.setTypeCla(classifierService.getById(model.getTypeCla()));
		dto.setCategoryCla(classifierService.getById(model.getCategoryCla()));
		dto.setCreatedAt(model.getCreatedAt());
		dto.setUpdatedAt(model.getUpdatedAt());

		return dto;
	}
}
