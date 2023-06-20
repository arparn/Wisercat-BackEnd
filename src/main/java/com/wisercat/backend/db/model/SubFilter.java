package com.wisercat.backend.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
	@JoinColumn(name = "filter_id")
	private Filter filter;

	@Column(name = "filter_parameter")
	private String filterParameter;
}
