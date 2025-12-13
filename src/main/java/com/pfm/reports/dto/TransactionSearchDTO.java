package com.pfm.reports.dto;

import com.pfm.core.model.ClassifierModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionSearchDTO {

	private String description;

	private BigDecimal amount;

	private Date date;

	private Date dateEnd;

	private ClassifierModel typeCla;

	private ClassifierModel categoryCla;

	private Date createdAt;

	private Date createdAtEnd;

	private Date updatedAt;

	private Date updatedAtEnd;

}
