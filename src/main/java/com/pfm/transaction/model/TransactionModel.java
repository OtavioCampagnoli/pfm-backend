package com.pfm.transaction.model;

import com.pfm.core.model.ClassifierModel;
import com.pfm.transaction.dto.TransactionSaveRequestDTO;
import com.pfm.transaction.dto.TransactionUpdateRequestDTO;
import jakarta.validation.Valid;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionModel {

	private Integer id;

	private String description;

	private BigDecimal amount;

	private ClassifierModel typeCla;

	private ClassifierModel categoryCla;

	private Date date;

	private Date createdAt;

	private Date updatedAt;

	public TransactionModel(@Valid TransactionSaveRequestDTO dto) {
			this.setAmount(dto.getAmount());
			this.setDescription(dto.getDescription());
			this.setDate(dto.getDate());
			this.setTypeCla(dto.getTypeCla());
			this.setCategoryCla(dto.getCategoryCla());
	}

	public TransactionModel(@Valid TransactionUpdateRequestDTO dto) {
		this.setId(dto.getId());
		this.setAmount(dto.getAmount());
		this.setDescription(dto.getDescription());
		this.setDate(dto.getDate());
		this.setTypeCla(dto.getTypeCla());
		this.setCategoryCla(dto.getCategoryCla());
	}
}
