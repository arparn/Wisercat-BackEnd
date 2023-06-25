package com.wisercat.backend.db.query;

import com.wisercat.backend.db.model.Person;
import com.wisercat.backend.db.model.Person_;
import com.wisercat.backend.dto.PersonFilter;
import com.wisercat.backend.service.exception.PredicateException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Calendar.YEAR;

@AllArgsConstructor
public class PersonQuery implements Specification<Person> {

	private static final String GET_YEAR = "get_year";
	private static final String TO_UPPER = "to_upper";

	// COLUMNS
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String AGE = "age";
	private static final String BIRTH_DATE = "birthDate";

	// COMPARATORS
	private static final String LESS = "LESS";
	private static final String LESS_OR_EQUAL = "LESS_OR_EQUAL";
	private static final String GREATER = "GREATER";
	private static final String GREATER_OR_EQUAL = "GREATER_OR_EQUAL";
	private static final String EQUAL = "EQUAL";
	private static final String CONTAINS = "CONTAINS";
	private static final String STARTS_WITH = "STARTS_WITH";
	private static final String ENDS_WITH = "ENDS_WITH";
	private static final String FROM = "FROM";
	private static final String TO = "TO";
	private static final String ON = "ON";

	private final PersonFilter filter;

	@Override
	public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();

		for (int i = 0; i < filter.getKeys().size(); i++) {
			switch (filter.getKeys().get(i)) {
				case AGE -> {
					Date date = new Date();

					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					calendar.add(YEAR, parseInt(filter.getValues().get(i)) * (-1));

					int requestedBirthYear = calendar.get(YEAR);

					switch (filter.getCriteria().get(i)) {
						case LESS -> predicates.add(criteriaBuilder.greaterThan(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
						case LESS_OR_EQUAL -> predicates.add(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
						case GREATER -> predicates.add(criteriaBuilder.lessThan(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
						case GREATER_OR_EQUAL -> predicates.add(criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
						case EQUAL -> predicates.add(criteriaBuilder.equal(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
						default -> throw new PredicateException("Failed to create predicate: Invalid age comparator.");
					}
				}
				case NAME -> getStringPredicates(predicates, criteriaBuilder, root.get(Person_.NAME), filter.getCriteria().get(i), filter.getValues().get(i));
				case SURNAME -> getStringPredicates(predicates, criteriaBuilder, root.get(Person_.SURNAME), filter.getCriteria().get(i), filter.getValues().get(i));
				case BIRTH_DATE -> {
					switch (filter.getCriteria().get(i)) {
						case FROM -> predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Person_.BIRTH_DATE), filter.getValues().get(i)));
						case TO -> predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Person_.BIRTH_DATE), filter.getValues().get(i)));
						case ON -> predicates.add(criteriaBuilder.equal(root.get(Person_.BIRTH_DATE), filter.getValues().get(i)));
						default -> throw new PredicateException("Failed to create predicate: Invalid birth date comparator.");
					}
				}
				default -> throw new PredicateException("Failed to create predicate: Invalid column name.");
			}
		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

	private void getStringPredicates(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Person> path, String comparator, String filterField) {
		switch (comparator) {
			case EQUAL, CONTAINS -> predicates.add(criteriaBuilder.like(criteriaBuilder.function(TO_UPPER, String.class, path), "%" + filterField.toUpperCase() + "%"));
			case STARTS_WITH -> predicates.add(criteriaBuilder.like(criteriaBuilder.function(TO_UPPER, String.class, path), filterField.toUpperCase() + "%"));
			case ENDS_WITH -> predicates.add(criteriaBuilder.like(criteriaBuilder.function(TO_UPPER, String.class, path), "%" + filterField.toUpperCase()));
			default -> throw new PredicateException("Failed to create predicate: Invalid String comparator");
		}
	}
}
