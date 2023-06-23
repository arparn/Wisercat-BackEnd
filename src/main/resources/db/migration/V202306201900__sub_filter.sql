CREATE TABLE sub_filter
(
	id          bigserial    not null primary key,
	filter_id   bigint       not null,
	column_name varchar(64)  not null,
	criteria    varchar(64)  not null check (check_criteria(criteria)),
	value       varchar(255) not null,

	constraint fk_filter_id foreign key (filter_id) references filter (id)
);