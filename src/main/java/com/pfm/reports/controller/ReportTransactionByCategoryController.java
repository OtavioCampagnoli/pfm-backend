package com.pfm.reports.controller;

import com.pfm.reports.dto.TransactionSearchDTO;
import com.pfm.reports.model.ReportTransactionByCategoryModel;
import com.pfm.reports.service.IReportTransactionByCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/reports/transaction/by-category")
@CrossOrigin(origins = "*")
public class ReportTransactionByCategoryController {

    private final IReportTransactionByCategoryService service;

    @Autowired
    ReportTransactionByCategoryController(IReportTransactionByCategoryService service) {
        this.service = service;
    }

    @GetMapping(path = "/find-all")
    public ResponseEntity<Map<String, List<ReportTransactionByCategoryModel>>> findAll() throws Exception {
        Map<String, List<ReportTransactionByCategoryModel>> transactions = service.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Map<String, List<ReportTransactionByCategoryModel>>> search(@RequestBody TransactionSearchDTO dto) {
        Map<String, List<ReportTransactionByCategoryModel>> transactions = this.service.search(dto);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
