package com.wisercat.backend.dto;

import com.wisercat.backend.dto.model.SubFilterDto;
import com.wisercat.backend.dto.web.PaginationRequest;
import com.wisercat.backend.dto.web.PersonFilterRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonFilter {

	private List<String> keys;
	private List<String> criteria;
	private List<String> values;

	private Pageable pageable;

	public static PersonFilter from(PersonFilterRequest request) {
		return PersonFilter.builder()
			.keys(request.getKeys() != null ? request.getKeys() : List.of())
			.criteria(request.getCriteria() != null ? request.getCriteria() : List.of())
			.values(request.getValues() != null ? request.getValues() : List.of())
			.build();
	}

	public static PersonFilter from(PersonFilterRequest request, PaginationRequest paginationRequest) {
		PersonFilter personFilter = PersonFilter.from(request);
		personFilter.setPageable(PageRequest.of(
			paginationRequest.getPage(),
			paginationRequest.getPageSize(),
			paginationRequest.getSortOrder(),
			paginationRequest.getSortColumn()
		));

		return personFilter;
	}
}
