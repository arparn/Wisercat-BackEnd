package com.wisercat.backend.controller;

import com.wisercat.backend.db.enums.FilterType;
import com.wisercat.backend.dto.model.FilterDto;
import com.wisercat.backend.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filter")
@RequiredArgsConstructor
public class FilterController {

	private final FilterService filterService;

	@GetMapping("/{type}")
	public List<FilterDto> getFilters(@PathVariable FilterType type) {
		return filterService.get(type);
	}

	@PostMapping("/save")
	public void saveFilter(@RequestBody FilterDto request) {
		filterService.save(request);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteFilter(@PathVariable Long id) {
		filterService.delete(id);
	}
}
