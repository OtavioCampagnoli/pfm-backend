package com.pfm.transaction.mapper;

import com.pfm.core.model.ClassifierModel;
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

			TransactionModel model = new TransactionModel();

			ClassifierModel classifierModel = new ClassifierModel();

			model.setId(rs.getInt("id"));
			model.setDescription(rs.getString("description"));
			model.setAmount(rs.getBigDecimal("amount"));
			model.setDate(rs.getDate("date"));
			classifierModel.setId(rs.getInt("type_cla"));
			model.setTypeCla(classifierModel);
			classifierModel.setId(rs.getInt("category_cla"));
			model.setCategoryCla(classifierModel);
			model.setDate(rs.getDate("date"));
			model.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
			model.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

			list.add(model);
		}
		return list;
	}

}
