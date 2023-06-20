package com.wisercat.backend.db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "filter")
public class Filter {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	@OneToMany(mappedBy = "filter", fetch = LAZY, cascade = REMOVE)
	private List<SubFilter> subFilters;
}
