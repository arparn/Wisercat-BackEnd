package com.wisercat.backend.controller;

import com.wisercat.backend.dto.PersonFilter;
import com.wisercat.backend.dto.model.PersonDto;
import com.wisercat.backend.dto.web.PaginationRequest;
import com.wisercat.backend.dto.web.PersonFilterRequest;
import com.wisercat.backend.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

	private final PersonService personService;

	@GetMapping("/filter")
	public Page<PersonDto> getPerson(@Valid PersonFilterRequest personFilterRequest,
	                                 @Valid PaginationRequest paginationRequest) {
		return personService.filter(PersonFilter.from(personFilterRequest, paginationRequest));
	}

}
