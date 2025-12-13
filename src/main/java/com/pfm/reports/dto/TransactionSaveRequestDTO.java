package com.pfm.reports.dto;

import com.pfm.core.model.ClassifierModel;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionSaveRequestDTO {

	@NotBlank
	@Size(min = 2, max = 255)
	private String description;

	@NotNull
	@Digits(integer = 10, fraction = 2)
	private BigDecimal amount;

	@NotNull
	private Date date;

	@NotNull
	private ClassifierModel typeCla;

	@NotNull
	private ClassifierModel categoryCla;
}
