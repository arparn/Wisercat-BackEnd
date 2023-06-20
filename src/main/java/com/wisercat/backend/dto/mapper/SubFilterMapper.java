package com.wisercat.backend.dto.mapper;

import com.wisercat.backend.db.model.SubFilter;
import com.wisercat.backend.dto.model.SubFilterDto;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubFilterMapper extends Converter<SubFilter, SubFilterDto> {

	@Override
	SubFilterDto convert(SubFilter entity);

	List<SubFilterDto> convert(List<SubFilter> entities);
}
