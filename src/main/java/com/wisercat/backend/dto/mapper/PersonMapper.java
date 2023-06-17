package com.wisercat.backend.dto.mapper;

import com.wisercat.backend.db.model.Person;
import com.wisercat.backend.dto.model.PersonDto;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper extends Converter<Person, PersonDto> {

	List<PersonDto> convert(List<Person> entities);
}
