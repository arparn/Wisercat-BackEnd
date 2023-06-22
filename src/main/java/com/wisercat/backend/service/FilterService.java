package com.wisercat.backend.service;

import com.wisercat.backend.db.model.SubFilter;
import com.wisercat.backend.dto.mapper.FilterMapper;
import com.wisercat.backend.dto.model.FilterDto;
import com.wisercat.backend.dto.model.SubFilterDto;
import com.wisercat.backend.repository.FilterRepository;
import com.wisercat.backend.db.model.Filter;
import com.wisercat.backend.repository.SubFilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterService {

	private final FilterRepository filterRepository;
	private final SubFilterRepository subFilterRepository;
	private final FilterMapper filterMapper;

	@Transactional
	public void save(FilterDto request) {
		Filter filter = Filter.from(request);
		filterRepository.save(filter);

		saveSubFilters(filter, request.getSubFilters());
	}

	@Transactional
	public List<FilterDto> get() {
		List<Filter> filters = filterRepository.findAll();

		return filterMapper.convert(filters);
	}

	private void saveSubFilters(Filter filter, List<SubFilterDto> subFilterDtos) {
		subFilterRepository.saveAll(
			subFilterDtos.stream()
				.map(dto -> SubFilter.from(filter, dto))
				.toList()
		);
	}
}
