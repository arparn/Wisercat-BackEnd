CREATE OR REPLACE FUNCTION check_filter_type(IN i_type TEXT) RETURNS BOOLEAN AS
$$
BEGIN
	RETURN i_type IN (
		'PERSON'
		);
END;
$$ LANGUAGE plpgsql IMMUTABLE
                    PARALLEL SAFE;