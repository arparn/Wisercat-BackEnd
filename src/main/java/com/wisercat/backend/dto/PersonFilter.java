package com.wisercat.backend.dto;

import com.wisercat.backend.dto.web.PaginationRequest;
import com.wisercat.backend.dto.web.PersonFilterRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonFilter {
	private Integer age;
	private String ageComparator;
	private String name;

	private Pageable pageable;

	public static PersonFilter from(PersonFilterRequest request) {
		return PersonFilter.builder()
			.age(request.getAge())
			.ageComparator(request.getAgeComparator())
			.name(request.getName())
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
