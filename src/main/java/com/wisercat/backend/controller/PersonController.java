package com.wisercat.backend.controller;

import com.wisercat.backend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

	private final PersonService personService;

}
