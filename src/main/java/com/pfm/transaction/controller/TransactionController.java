package com.pfm.transaction.controller;

import com.pfm.transaction.dto.TransactionSaveOrUpdateDTO;
import com.pfm.transaction.dto.TransactionSearchDTO;
import com.pfm.transaction.dto.TransactionResponseDTO;
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
	@GetMapping(path = "/listAll")
	public ResponseEntity<List<TransactionResponseDTO>> listAll() throws Exception {
		List<TransactionResponseDTO> transactions = service.listAll();
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
	public ResponseEntity<TransactionModel> save(@RequestBody @Valid TransactionSaveOrUpdateDTO dto) throws Exception {
		TransactionModel model = this.service.convertToModel(dto);

		TransactionModel response = this.service.saveOrUpdate(model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) throws Exception {
    	Boolean response = this.service.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
