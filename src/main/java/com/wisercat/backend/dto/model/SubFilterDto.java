package com.wisercat.backend.dto.model;

import com.wisercat.backend.db.enums.FilterCriteria;
import com.wisercat.backend.db.enums.FilterType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubFilterDto {

	private FilterType type;

	private FilterCriteria criteria;

	private String value;
}
