package com.wisercat.backend.dto.model;

import com.wisercat.backend.db.enums.FilterType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FilterDto {

	private String name;

	private FilterType filterType;

	private List<SubFilterDto> subFilters;
}
