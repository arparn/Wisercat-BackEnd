CREATE TABLE sub_filter
(
	id bigserial not null primary key,
	filter_id bigint not null,
	filter_parameter varchar(255) not null,

	constraint fk_filter_id foreign key (filter_id) references filter (id)
);