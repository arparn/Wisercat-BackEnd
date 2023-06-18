package com.wisercat.backend.db.query;

import com.wisercat.backend.db.model.Person;
import com.wisercat.backend.db.model.Person_;
import com.wisercat.backend.dto.PersonFilter;
import com.wisercat.backend.service.exception.PredicateException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.YEAR;

@AllArgsConstructor
public class PersonQuery implements Specification<Person> {

	private static final String GET_YEAR = "get_year";

	private static final String LESS = "less";
	private static final String LESS_OR_EQUAL = "less-or-equal";
	private static final String GREATER = "greater";
	private static final String GREATER_OR_EQUAL = "greater-or-equal";
	private static final String EQUAL = "equal";

	private final PersonFilter filter;

	@Override
	public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();

		if (filter.getAge() != null) {
			Date date = new Date();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(YEAR, filter.getAge() * (-1));

			int requestedBirthYear = calendar.get(YEAR);

			switch (filter.getAgeComparator()) {
				case LESS -> predicates.add(criteriaBuilder.greaterThan(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
				case LESS_OR_EQUAL -> predicates.add(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
				case GREATER -> predicates.add(criteriaBuilder.lessThan(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
				case GREATER_OR_EQUAL -> predicates.add(criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
				case EQUAL -> predicates.add(criteriaBuilder.equal(criteriaBuilder.function(GET_YEAR, Integer.class, root.get(Person_.BIRTH_DATE)), requestedBirthYear));
				default -> throw new PredicateException("Error creating predicate: Invalid age comparator");
			}
		}

		if (filter.getName() != null) {
			predicates.add(criteriaBuilder.like(root.get(Person_.NAME), "%" + filter.getName() + "%"));
		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
}
