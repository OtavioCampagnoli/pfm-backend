package com.pfm.transaction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionSaveOrUpdateDTO {

	private Integer id;

	@NotBlank
	@Size(min = 2, max = 255)
	private String description;

	@NotNull
	@Digits(integer = 10, fraction = 2)
	private BigDecimal amount;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	@NotNull
	private Integer typeCla;

	@NotNull
	private Integer categoryCla;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime updatedAt;

}
