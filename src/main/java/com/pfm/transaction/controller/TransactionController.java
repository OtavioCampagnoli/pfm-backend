package com.pfm.transaction.controller;

import com.pfm.transaction.dto.TransactionSaveRequestDTO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.dto.TransactionUpdateRequestDTO;
import com.pfm.transaction.model.TransactionModel;
import com.pfm.transaction.service.ITransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

	private final ITransactionService service;

	@Autowired
	TransactionController(ITransactionService service) {
		this.service = service;
	}

	@GetMapping(path = "/findAll")
	public ResponseEntity<List<TransactionModel>> findAll() throws Exception {
		List<TransactionModel> transactions = service.findAll();
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<TransactionModel> getById(@PathVariable Integer id) throws Exception {
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
	public ResponseEntity<TransactionModel> save(@RequestBody @Valid TransactionSaveRequestDTO dto) throws Exception {
		TransactionModel model = new TransactionModel(dto);
		TransactionModel response = this.service.save(model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<TransactionModel> update(@RequestBody @Valid TransactionUpdateRequestDTO dto) throws Exception {
		TransactionModel model = new TransactionModel(dto);
		TransactionModel response = this.service.update(model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) throws Exception {
    	Boolean response = this.service.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
