package com.pfm.reports.dao;

import com.pfm.core.dao.IBaseDAO;
import com.pfm.reports.dto.TransactionSearchDTO;
import com.pfm.reports.model.ReportTransactionByCategoryModel;

import java.util.List;
import java.util.Map;

public interface IReportTransactionByCategoryDAO {
    Map<String, List<ReportTransactionByCategoryModel>> search(TransactionSearchDTO dto);

    Map<String, List<ReportTransactionByCategoryModel>> findAll(TransactionSearchDTO dto);

}
