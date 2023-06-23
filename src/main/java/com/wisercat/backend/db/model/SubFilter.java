package com.wisercat.backend.db.model;

import com.wisercat.backend.db.enums.FilterCriteria;
import com.wisercat.backend.dto.model.SubFilterDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "sub_filter")
public class SubFilter {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "filter_id", nullable = false)
	private Filter filter;

	@Column(name = "column_name", nullable = false)
	private String column;

	@Enumerated(STRING)
	@Column(name = "criteria", nullable = false)
	private FilterCriteria criteria;

	@Column(name = "value", nullable = false)
	private String value;

	@Transient
	public static SubFilter from(Filter filter, SubFilterDto subFilterDto) {
		return SubFilter.builder()
			.filter(filter)
			.column(subFilterDto.getKey())
			.criteria(subFilterDto.getCriteria())
			.value(subFilterDto.getValue())
			.build();
	}
}
