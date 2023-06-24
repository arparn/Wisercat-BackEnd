CREATE TABLE person
(
	id         bigserial    not null primary key,
	name       varchar(255) not null,
	surname    varchar(255) not null,
	birth_date date         not null
);