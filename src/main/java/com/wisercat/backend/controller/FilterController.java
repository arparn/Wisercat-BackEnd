package com.wisercat.backend.controller;

import com.wisercat.backend.dto.model.FilterDto;
import com.wisercat.backend.service.FilterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filter")
@RequiredArgsConstructor
public class FilterController {

	private final FilterService filterService;

	@GetMapping
	public List<FilterDto> getFilters() {
		return filterService.get();
	}

	@PostMapping
	public void saveFilter(@Valid FilterDto request) {
		filterService.save(request);
	}
}
