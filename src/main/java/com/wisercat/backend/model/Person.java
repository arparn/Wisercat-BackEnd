package com.wisercat.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.IDENTITY;


@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;
}
