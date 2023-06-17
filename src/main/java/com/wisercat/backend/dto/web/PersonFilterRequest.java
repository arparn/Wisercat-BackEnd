package com.wisercat.backend.dto.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonFilterRequest {
	private Integer age;
	private String ageComparator;
	private String name;
}
