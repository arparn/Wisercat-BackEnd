package com.wisercat.backend.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public enum FilterType {

	PERSON("PERSON");

	private final String type;
}
