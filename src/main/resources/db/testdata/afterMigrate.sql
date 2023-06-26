with data(name, surname, birth_date)  as (
	values
		('Artur', 'Pärnoja', '2000-03-10'::date),
		('Mart', 'Mets', '2001-04-20'::date),
		('Mari', 'Kivi', '1995-10-10'::date),
		('Oskar', 'Tark', '1987-06-24'::date),
		('Liisi', 'Raa', '1999-07-10'::date),
		('Juri', 'Raa', '1999-07-10'::date),
		('Mart', 'Kivi', '2001-08-11'::date),
		('Martin', 'Juht', '1976-09-01'::date),
		('Monika', 'Lõbus', '2008-11-10'::date),
		('Aleksander', 'Saar', '1978-05-22'::date),
		('Juri', 'Mets', '2001-04-20'::date),
		('Rasmus', 'Metsva', '1996-09-09'::date),
		('Tõnis', 'Jõgi', '1985-05-05'::date),
		('Marion', 'Raudsep', '1980-01-12'::date),
		('Kristi', 'Rist', '1990-09-16'::date)
)
insert into person (name, surname, birth_date)
select d.name, d.surname, d.birth_date
from data d
WHERE NOT EXISTS (SELECT * FROM person);


with data(name, filter_type)  as (
	values
		('Filter names begins with ma', 'PERSON'),
		('Filter people older than 25', 'PERSON')
)
insert into filter (name, filter_type)
select d.name, d.filter_type
from data d
WHERE NOT EXISTS (SELECT * FROM filter);


with data(filter_id, column_name, criteria, value)  as (
	values
		(1, 'name', 'STARTS_WITH', 'ma'),
		(2, 'age', 'GREATER_OR_EQUAL', '25')
)
insert into sub_filter (filter_id, column_name, criteria, value)
select d.filter_id, d.column_name, d.criteria, d.value
from data d
WHERE NOT EXISTS (SELECT * FROM sub_filter);
