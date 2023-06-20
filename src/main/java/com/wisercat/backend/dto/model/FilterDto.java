package com.wisercat.backend.dto.model;

import com.wisercat.backend.db.model.SubFilter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FilterDto {

	private List<SubFilter> subFilters;
}
