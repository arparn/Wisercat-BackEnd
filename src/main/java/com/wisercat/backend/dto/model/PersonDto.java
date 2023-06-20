package com.wisercat.backend.dto.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PersonDto {

	private String name;

	private Integer age;

	private Date birthDate;
}
