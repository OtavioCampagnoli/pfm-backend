package com.pfm.core.model;

import lombok.*;

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

}
