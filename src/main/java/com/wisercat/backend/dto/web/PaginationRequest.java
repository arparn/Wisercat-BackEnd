package com.wisercat.backend.dto.web;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
public class PaginationRequest {
	@PositiveOrZero
	private int page = 0;

	@PositiveOrZero
	private int pageSize = 10;

	@NotNull
	private Sort.Direction sortOrder = Sort.Direction.DESC;

	@NotNull
	private String sortColumn;

	public Pageable toPageable() {
		return PageRequest.of(
			page,
			pageSize,
			sortOrder,
			sortColumn);
	}
}
