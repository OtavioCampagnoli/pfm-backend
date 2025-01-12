package com.pfm.core.model;

import com.pfm.core.dto.ClassifierSaveRequestDTO;
import com.pfm.core.dto.ClassifierSearchRequestDTO;
import com.pfm.core.dto.ClassifierUpdateRequestDTO;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClassifierModel {

	private Integer id;

	private String value;

	private String type;

	private String label;

	private String description;

	public ClassifierModel(@Valid ClassifierSearchRequestDTO dto) {
		if (Objects.nonNull(dto)) {
			setValue(dto.getValue());
			setDescription(dto.getDescription());
			setType(dto.getType());
			setLabel(dto.getLabel());
		}
	}

	public ClassifierModel(@Valid ClassifierSaveRequestDTO dto) {
		setValue(dto.getValue());
		setDescription(dto.getDescription());
		setType(dto.getType());
		setLabel(dto.getLabel());
	}

	public ClassifierModel(@Valid ClassifierUpdateRequestDTO dto) {
		setId(dto.getId());
		setValue(dto.getValue());
		setDescription(dto.getDescription());
		setType(dto.getType());
		setLabel(dto.getLabel());
	}
}
