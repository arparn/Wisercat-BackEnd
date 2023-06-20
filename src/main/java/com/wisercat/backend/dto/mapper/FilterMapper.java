package com.wisercat.backend.dto.mapper;

import com.wisercat.backend.db.model.Filter;
import com.wisercat.backend.dto.model.FilterDto;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubFilterMapper.class)
public interface FilterMapper extends Converter<Filter, FilterDto> {

	@Override
	FilterDto convert(Filter entity);

	List<FilterDto> convert(List<Filter> entities);
}
