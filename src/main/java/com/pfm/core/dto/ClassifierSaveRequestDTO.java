package com.pfm.core.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClassifierSaveRequestDTO {

	private Integer id;

	@NotBlank
	@Length(max = 50)
	private String value;

	@NotBlank
	@Length(max = 50)
	private String type;

	@NotBlank
	@Length(max = 100)
	private String label;

	@Length(max = 150)
	private String description;
}
