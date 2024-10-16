package com.pfm.api.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.pfm.api.transaction.enums.TransactionCategory;
import com.pfm.api.transaction.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedTransactionFilterDTO {
	
	private Long id;
	
	private String description;
	
	private BigDecimal amount;
	
	private Date date;
	
	private TransactionType type;
	
	private TransactionCategory category;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
}
