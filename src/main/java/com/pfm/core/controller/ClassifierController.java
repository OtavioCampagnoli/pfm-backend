package com.pfm.core.controller;

import com.pfm.core.dto.ClassifierSaveRequestDTO;
import com.pfm.core.dto.ClassifierSearchRequestDTO;
import com.pfm.core.model.ClassifierModel;
import com.pfm.core.service.IClassifierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classifier")
@CrossOrigin(origins = "*")
public class ClassifierController {

	@Autowired
	private IClassifierService service;

	@GetMapping(path = "/listAll")
	public ResponseEntity<List<ClassifierModel>> listAll() throws Exception {
		List<ClassifierModel> classifiers = service.findAll();
		return new ResponseEntity<>(classifiers, HttpStatus.OK);
	}

	@PostMapping(path = "/listAllByType")
	public ResponseEntity<List<ClassifierModel>> listAllByType(@RequestBody @Valid ClassifierSearchRequestDTO dto) throws Exception {
		var model = service.convertClassifierSearchRequestDTOToClassifierModel(dto);
		List<ClassifierModel> classifiers = service.findAllByType(model);
		return new ResponseEntity<>(classifiers, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ClassifierModel> getById(@PathVariable Integer id) throws Exception {
		ClassifierModel response = this.service.getById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/search")
	public ResponseEntity<List<ClassifierModel>> search(@RequestBody @Valid ClassifierSearchRequestDTO dto) throws Exception {
		var model = service.convertClassifierSearchRequestDTOToClassifierModel(dto);
		List<ClassifierModel> classifiers = service.search(model);
		return new ResponseEntity<>(classifiers, HttpStatus.OK);
	}

	@PostMapping("/paginatedSearch")
	public ResponseEntity<List<ClassifierModel>> paginatedSearch(@RequestBody @Valid ClassifierSearchRequestDTO dto,
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy, 
			@RequestParam(defaultValue = "1") int sortDirection)
			throws Exception {
		var model = service.convertClassifierSearchRequestDTOToClassifierModel(dto);
		return ResponseEntity.ok(service.paginatedSearch(model, page, size, sortBy, sortDirection));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClassifierModel> save(@RequestBody @Valid ClassifierSaveRequestDTO dto) throws Exception {
		ClassifierModel model = service.convertClassifierSaveRequestDTOToClassifierModel(dto);
		ClassifierModel response = this.service.saveOrUpdate(model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) throws Exception {
		Boolean response = this.service.deleteById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
