package com.wisercat.backend.dto.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FilterDto {

	private String name;

	private List<SubFilterDto> subFilters;
}
