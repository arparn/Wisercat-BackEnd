package com.wisercat.backend.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;


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

	@Column(name = "birth_date")
	private Date birthDate;

	@Transient
	public int getAge() {
		Calendar personBirthDate = getCalendar(birthDate);
		Calendar currentDate = getCalendar(new Date());
		int diff = currentDate.get(YEAR) - personBirthDate.get(YEAR);

		if (personBirthDate.get(MONTH) > currentDate.get(MONTH) ||
		    (personBirthDate.get(MONTH) == currentDate.get(MONTH) && personBirthDate.get(DATE) > currentDate.get(DATE))) {
			diff--;
		}

		return diff;
	}

	private Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance(Locale.US);
		calendar.setTime(date);

		return calendar;
	}
}
