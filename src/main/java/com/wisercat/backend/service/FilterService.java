package com.wisercat.backend.service;

import com.wisercat.backend.dto.mapper.FilterMapper;
import com.wisercat.backend.dto.model.FilterDto;
import com.wisercat.backend.dto.web.FilterRequest;
import com.wisercat.backend.repository.FilterRepository;
import com.wisercat.backend.db.model.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterService {

	private final FilterRepository filterRepository;
	private final FilterMapper filterMapper;

	@Transactional
	public void save(FilterRequest request) {
		// TODO save
	}

	@Transactional
	public List<FilterDto> get() {
		List<Filter> filters = filterRepository.findAll();

		return filterMapper.convert(filters);
	}
}
