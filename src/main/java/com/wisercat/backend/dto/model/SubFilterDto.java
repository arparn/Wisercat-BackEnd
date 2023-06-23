package com.wisercat.backend.dto.model;

import com.wisercat.backend.db.enums.FilterCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubFilterDto {

	private String key;

	private FilterCriteria criteria;

	private String value;
}
