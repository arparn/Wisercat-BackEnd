CREATE TABLE person
(
	id         bigserial    not null primary key,
	name       varchar(256) not null,
	birth_date date         not null
);