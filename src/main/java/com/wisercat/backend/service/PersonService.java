package com.wisercat.backend.service;

import com.wisercat.backend.db.model.Person;
import com.wisercat.backend.db.query.PersonQuery;
import com.wisercat.backend.dto.PersonFilter;
//import com.wisercat.backend.dto.mapper.PersonMapper;
import com.wisercat.backend.dto.model.PersonDto;
import com.wisercat.backend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;
	//private final PersonMapper personMapper;

	@Transactional
	public Page<PersonDto> filter(PersonFilter filter) {
		Page<Person> page =personRepository.findAll(new PersonQuery(filter), filter.getPageable());

		return new PageImpl<>(
			null,//personMapper.convert(page.getContent()),
			page.getPageable(),
			page.getTotalElements()
		);
	}
}
