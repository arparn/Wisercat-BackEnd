package com.wisercat.backend.service;

import com.wisercat.backend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;
}
