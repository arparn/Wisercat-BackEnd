package com.wisercat.backend.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public enum FilterCriteria {

	LESS("LESS"),

	LESS_OR_EQUAL("LESS_OR_EQUAL"),

	GREATER("GREATER"),

	GREATER_OR_EQUAL("GREATER_OR_EQUAL"),

	EQUAL("EQUAL"),

	CONTAINS("CONTAINS"),

	STARTS_WITH("STARTS_WITH"),

	ENDS_WITH("ENDS_WITH"),

	FROM("FROM"),

	TO("TO"),

	ON("ON");

	private final String criteria;
}
