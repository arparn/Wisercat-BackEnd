CREATE OR REPLACE FUNCTION check_string_criteria(IN i_criteria TEXT) RETURNS BOOLEAN AS
$$
BEGIN
	RETURN i_criteria IN (
	                  'EQUAL',
	                  'CONTAINS'
		);
END;
$$ LANGUAGE plpgsql IMMUTABLE
                    PARALLEL SAFE;