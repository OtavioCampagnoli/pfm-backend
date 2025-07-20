package com.pfm.reports.dao.imp;

import com.pfm.core.config.BaseDAO;
import com.pfm.reports.dao.IReportTransactionByCategoryDAO;
import com.pfm.reports.dto.TransactionSearchDTO;
import com.pfm.reports.mapper.ReportTransactionByCategoryMapper;
import com.pfm.reports.model.ReportTransactionByCategoryModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Log4j2
@Repository
public class ReportTransactionByCategoryDAO extends BaseDAO implements IReportTransactionByCategoryDAO {

    @Override
    public Map<String, List<ReportTransactionByCategoryModel>> search(TransactionSearchDTO dto) {

        String query =
                """
                    select
                    	t.category_cla,
                    	c.label,
                    	c.description,
                    	c.value,
                    	SUM(t.amount) as amount_by_category
                    from
                    	`transaction` t
                    inner join classifier c on
                    	t.type_cla = c.cla_id
                    group by
                    	t.category_cla,
                    	c.label,
                    	c.description,
                    	c.value
                """;
        
        return this.namedParameterJdbcTemplate.query(query, new ReportTransactionByCategoryMapper());
    }

    @Override
    public Map<String, List<ReportTransactionByCategoryModel>> findAll(TransactionSearchDTO dto) {
        return Map.of();
    }

}
