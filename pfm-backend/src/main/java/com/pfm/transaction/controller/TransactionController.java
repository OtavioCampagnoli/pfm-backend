package com.pfm.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.model.TransactionModel;
import com.pfm.transaction.service.ITransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

	@Autowired
	ITransactionService service;

	@GetMapping(path = "/listAll")
	public ResponseEntity<List<TransactionModel>> listAll() {
		List<TransactionModel> transactions = service.findAll();
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<TransactionModel> getById(@PathVariable Integer id) {
		TransactionModel response = this.service.getById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

    @PostMapping("/search")
    public ResponseEntity<List<TransactionModel>> search(@RequestBody TransactionSearchDTO dto) {
        List<TransactionModel> transactions = this.service.search(dto);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

	@PostMapping
	@Transactional
	public ResponseEntity<TransactionModel> save(@RequestBody @Valid TransactionModel model) {
		TransactionModel response = this.service.saveOrUpdate(model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
    	Boolean response = this.service.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
