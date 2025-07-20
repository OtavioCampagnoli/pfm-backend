package com.pfm.reports.service.imp;

import com.pfm.reports.dto.TransactionSearchDTO;
import com.pfm.reports.model.ReportTransactionByCategoryModel;
import com.pfm.reports.service.IReportTransactionByCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportTransactionByCategoryService implements IReportTransactionByCategoryService {

    @Override
    public Map<String, List<ReportTransactionByCategoryModel>> search(TransactionSearchDTO dto) {
        return Map.of();
    }

    @Override
    public Map<String, List<ReportTransactionByCategoryModel>> findAll() {
        return Map.of();
    }
}
