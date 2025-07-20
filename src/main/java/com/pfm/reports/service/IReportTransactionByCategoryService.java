package com.pfm.reports.service;

import com.pfm.core.service.IBaseService;
import com.pfm.reports.dto.TransactionSearchDTO;
import com.pfm.reports.model.ReportTransactionByCategoryModel;

import java.util.List;
import java.util.Map;

public interface IReportTransactionByCategoryService {
    Map<String, List<ReportTransactionByCategoryModel>> search(TransactionSearchDTO dto);

    Map<String, List<ReportTransactionByCategoryModel>> findAll();
}
