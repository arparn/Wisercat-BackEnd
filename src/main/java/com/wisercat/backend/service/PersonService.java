package com.wisercat.backend.service;

import com.wisercat.backend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;

	@Transactional
	public String getPerson() {
		return personRepository.findAll().get(0).getName();
	}
}
