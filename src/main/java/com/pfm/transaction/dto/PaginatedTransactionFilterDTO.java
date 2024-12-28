package com.pfm.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedTransactionFilterDTO {
	
	private Long id;
	
	private String description;
	
	private BigDecimal amount;
	
	private Date date;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
}
