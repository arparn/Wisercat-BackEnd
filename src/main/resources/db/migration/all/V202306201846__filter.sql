-- Function body will be defined in repeatable Flyway folder 'function'.
CREATE FUNCTION check_filter_type(IN i_type TEXT) RETURNS BOOLEAN AS $$ BEGIN RETURN FALSE; END; $$ LANGUAGE plpgsql;

CREATE TABLE filter
(
	id          bigserial    not null primary key,
	name        varchar(255) not null,
	filter_type varchar(64)  not null check (check_filter_type(filter_type))
);