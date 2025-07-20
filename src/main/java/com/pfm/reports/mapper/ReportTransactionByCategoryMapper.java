package com.pfm.reports.mapper;

import com.pfm.core.model.ClassifierModel;
import com.pfm.reports.model.ReportTransactionByCategoryModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReportTransactionByCategoryMapper implements ResultSetExtractor<Map<String, List<ReportTransactionByCategoryModel>>> {

    @Override
    public Map<String, List<ReportTransactionByCategoryModel>> extractData(ResultSet rs) throws SQLException, DataAccessException {

        Map<String, List<ReportTransactionByCategoryModel>> reports = new LinkedHashMap<>();

        while (rs.next()) {

            ReportTransactionByCategoryModel model = new ReportTransactionByCategoryModel();

            ClassifierModel typeCla = new ClassifierModel();

            ClassifierModel categoryCla = new ClassifierModel();

            model.setDescription(rs.getString("description"));
            model.setAmount(rs.getBigDecimal("amount"));

            typeCla.setId(rs.getInt("type_cla"));
            model.setTypeCla(typeCla);

            categoryCla.setId(rs.getInt("category_cla"));
            model.setCategoryCla(categoryCla);

//			model.setDate(rs.getDate("date"));
//			model.setCreatedAt(rs.getTimestamp("created_at"));
//			model.setUpdatedAt(rs.getTimestamp("updated_at"));

            String reportKey = rs.getString("report_key");
            if (!reports.containsKey(reportKey)) {
                reports.put(reportKey, new LinkedList<>());
            }
            reports.get(reportKey).add(model);
        }
        return reports;
    }

}
