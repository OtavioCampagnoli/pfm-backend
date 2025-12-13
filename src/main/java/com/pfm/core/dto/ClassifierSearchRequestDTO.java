package com.pfm.core.dto;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClassifierSearchRequestDTO {

	@Length(max = 50)
	private String value;

	@Length(max = 50)
	private String type;

	@Length(max = 100)
	private String label;

	@Length(max = 150)
	private String description;
}
