CREATE TABLE sub_filter
(
	id        bigserial    not null primary key,
	filter_id bigint       not null,
	type      varchar(64) not null check (check_filter_type(type)),
	criteria  varchar(64) not null,
	value     varchar(255) not null,

	constraint criteria_check check (
	    (type = 'AMOUNT' and check_amount_criteria(criteria) or
	     (type = 'STRING' and check_string_criteria(criteria)) or
	     (type = 'DATE' and check_date_criteria(criteria)))
		),

	constraint fk_filter_id foreign key (filter_id) references filter (id)
);