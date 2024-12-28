package com.pfm.transaction.mapper;

import com.pfm.transaction.model.TransactionModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
			transaction.setTypeCla(rs.getInt("type_cla"));
			transaction.setCategoryCla(rs.getInt("category_cla"));
			transaction.setDate(rs.getDate("date"));
			transaction.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
			transaction.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

			list.add(transaction);
		}
		return list;
	}

}
