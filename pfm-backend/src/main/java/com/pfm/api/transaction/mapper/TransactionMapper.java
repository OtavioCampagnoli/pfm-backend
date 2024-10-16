package com.pfm.api.transaction.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pfm.api.transaction.enums.TransactionCategory;
import com.pfm.api.transaction.enums.TransactionType;
import com.pfm.api.transaction.model.TransactionModel;

public class TransactionMapper implements ResultSetExtractor<List<TransactionModel>> {

	@Override
	public List<TransactionModel> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<TransactionModel> list = new LinkedList<TransactionModel>();

		while (rs.next()) {

			TransactionModel transaction = new TransactionModel();

			transaction.setId(rs.getInt("id"));
			transaction.setDescription(rs.getString("description"));
			transaction.setAmount(rs.getBigDecimal("amount"));
			transaction.setDate(rs.getDate("date"));

			String type = rs.getString("type");
			transaction.setType(TransactionType.valueOf(type));

			String category = rs.getString("category");
			transaction.setCategory(TransactionCategory.valueOf(category));

			transaction.setDate(rs.getDate("date"));
			transaction.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
			transaction.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

			list.add(transaction);
		}
		return list;
	}

}
