package com.pfm.transaction.dao.imp;

import com.pfm.core.config.BaseDAO;
import com.pfm.transaction.dao.ITransactionDAO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.mapper.TransactionMapper;
import com.pfm.transaction.model.TransactionModel;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TransactionDAO extends BaseDAO implements ITransactionDAO {

	@Override
	public TransactionModel save(TransactionModel model) {

		StringBuilder query = new StringBuilder();

		query.append("INSERT INTO " + schemaName + "transaction ");
		query.append("( ");
		query.append("description, ");
		query.append("amount, ");
		query.append("date, ");
		query.append("type_cla, ");
		query.append("category_cla, ");
		query.append("created_at ");
		query.append(") VALUES ( ");
		query.append(":description, ");
		query.append(":amount, ");
		query.append(":date, ");
		query.append(":typeCla, ");
		query.append(":categoryCla, ");
		query.append("now() ");
		query.append(" ) ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("description", model.getDescription());
		params.addValue("amount", model.getAmount());
		params.addValue("date", model.getDate());
		params.addValue("typeCla", model.getTypeCla());
		params.addValue("categoryCla", model.getCategoryCla());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.namedParameterJdbcTemplate.update(query.toString(), params, keyHolder, new String[] { "id" });

		Number generatedId = keyHolder.getKey();

		if (generatedId != null) {
			model.setId(generatedId.intValue());
		}

		return model;
	}

	@Override
	public List<TransactionModel> paginatedSearch(TransactionModel model, int page, int size, String sortBy, int sortDirection) throws Exception {
		return List.of();
	}

	@Override
	public TransactionModel update(TransactionModel model) {

		StringBuilder query = new StringBuilder();

		query.append("UPDATE ").append(this.schemaName).append("transaction ");
		query.append("SET ");
		query.append("description = :description, ");
		query.append("amount = :amount, ");
		query.append("date = :date, ");
		query.append("type_cla = :typeCla, ");
		query.append("category_cla = :categoryCla, ");
		query.append("updated_at = now() ");
		query.append("WHERE id = :id ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("description", model.getDescription());
		params.addValue("amount", model.getAmount());
		params.addValue("date", model.getDate());
		params.addValue("typeCla", model.getTypeCla());
		params.addValue("categoryCla", model.getCategoryCla());
		params.addValue("id", model.getId());

		this.namedParameterJdbcTemplate.update(query.toString(), params);

		return model;
	}

	@Override
	public Boolean deleteById(Integer id) {

		StringBuffer query = new StringBuffer();
		query.append("DELETE FROM ").append(this.schemaName).append("transaction ");
		query.append("WHERE id = :id ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		int rowsAffected = this.namedParameterJdbcTemplate.update(query.toString(), params);

		return rowsAffected > 0;
	}

	@Override
	public TransactionModel getById(Integer id) {

		TransactionModel objectReturn = new TransactionModel();

		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append("tra.id, ");
		query.append("tra.description, ");
		query.append("tra.amount, ");
		query.append("tra.date, ");
		query.append("tra.type_cla, ");
		query.append("tra.category_cla, ");
		query.append("tra.created_at, ");
		query.append("tra.updated_at ");
		query.append("FROM ").append(this.schemaName).append("transaction AS tra ");
		query.append("WHERE id = :id");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		List<TransactionModel> list = this.namedParameterJdbcTemplate.query(query.toString(), params, new TransactionMapper());

		if (!list.isEmpty()) {
			objectReturn = list.get(0);
		}

		return objectReturn;
	}

	@Override
	public List<TransactionModel> findAll() {

		List<TransactionModel> listReturn = new LinkedList<TransactionModel>();

		StringBuilder query = new StringBuilder();
		query.append(" SELECT tra.id, ");
		query.append(" tra.description, ");
		query.append(" tra.amount, ");
		query.append(" tra.date, ");
		query.append(" tra.type_cla, ");
		query.append(" tra.category_cla, ");
		query.append(" tra.created_at, ");
		query.append(" tra.updated_at ");
		query.append(" FROM ").append(this.schemaName).append("transaction AS tra ");
		query.append(" ORDER BY tra.updated_at DESC ");

		List<TransactionModel> list = this.jdbcTemplate.query(query.toString(), new TransactionMapper());

		if (!list.isEmpty()) {
			listReturn.addAll(list);
		}

		return listReturn;
	}

	@Override
	public List<TransactionModel> search(TransactionSearchDTO dto) {

		List<TransactionModel> listReturn = new LinkedList<TransactionModel>();

		StringBuilder query = new StringBuilder();

		query.append("SELECT ");
		query.append("tra.id, ");
		query.append("tra.description, ");
		query.append("tra.amount, ");
		query.append("tra.date, ");
		query.append("tra.type_cla, ");
		query.append("tra.category_cla, ");
		query.append("tra.created_at, ");
		query.append("tra.updated_at ");
		query.append(" FROM ").append(this.schemaName).append("transaction AS tra ");
		query.append("WHERE tra.id > 0 ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		if (dto.getDescription() != null) {
			query.append("AND tra.description LIKE :description ");
			params.addValue("description", "%" + dto.getDescription() + "%");
		}

		if (dto.getAmount() != null) {
			query.append("AND tra.amount = :amount ");
			params.addValue("amount", dto.getAmount());
		}

		if (dto.getDate() != null && dto.getDateEnd() != null) {
			query.append("AND tra.date BETWEEN :date AND :dateEnd ");
			params.addValue("date", dto.getDate());
			params.addValue("dateEnd", dto.getDateEnd());
		} else if (dto.getDate() != null) {
			query.append("AND tra.date >= :date ");
			params.addValue("date", dto.getDate());
		}

		if (dto.getTypeCla() != null) {
			query.append("AND tra.type_cla = :typeCla ");
			params.addValue("typeCla", dto.getTypeCla());
		}

		if (dto.getCategoryCla() != null) {
			query.append("AND tra.category_cla = :categoryCla ");
			params.addValue("categoryCla", dto.getCategoryCla());
		}

		if (dto.getCreatedAt() != null && dto.getCreatedAtEnd() != null) {
			query.append("AND tra.created_at BETWEEN :createdAt AND :createdAtEnd ");
			params.addValue("createdAt", dto.getCreatedAt());
			params.addValue("createdAtEnd", dto.getCreatedAtEnd());
		} else if (dto.getCreatedAt() != null) {
			query.append("AND tra.created_at BETWEEN :createdAt AND now() ");
			params.addValue("createdAt", dto.getCreatedAt());
		}

		if (dto.getUpdatedAt() != null && dto.getUpdatedAtEnd() != null) {
			query.append("AND tra.updated_at BETWEEN :updatedAt AND :updatedAtEnd ");
			params.addValue("updatedAt", dto.getUpdatedAt());
			params.addValue("updatedAtEnd", dto.getUpdatedAtEnd());
		} else if (dto.getUpdatedAt() != null) {
			query.append("AND tra.updated_at BETWEEN :updatedAt AND now() ");
			params.addValue("updatedAt", dto.getUpdatedAt());
		}

		List<TransactionModel> list = this.namedParameterJdbcTemplate.query(query.toString(), params, new TransactionMapper());

		if (!list.isEmpty()) {
			listReturn.addAll(list);
		}

		return listReturn;
	}

	@Override
	public List<TransactionModel> search(TransactionModel model) {
		return null;
	}

}
