package com.pfm.core.mapper;

import com.pfm.core.model.ClassifierModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ClassifierMapper implements ResultSetExtractor<List<ClassifierModel>> {

	@Override
	public List<ClassifierModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<ClassifierModel> list = new LinkedList<ClassifierModel>();

		while (rs.next()) {

			ClassifierModel classifier = new ClassifierModel();

			classifier.setId(rs.getInt("cla_id"));
			classifier.setValue(rs.getString("value"));
			classifier.setType(rs.getString("type"));
			classifier.setLabel(rs.getString("label"));
			classifier.setDescription(rs.getString("description"));

			list.add(classifier);
		}
		return list;
	}

}
