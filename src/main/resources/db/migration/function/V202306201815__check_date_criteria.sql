CREATE OR REPLACE FUNCTION check_date_criteria(IN i_criteria TEXT) RETURNS BOOLEAN AS
$$
BEGIN
	RETURN i_criteria IN (
	                      'FROM',
	                      'TO',
	                      'ON'
		);
END;
$$ LANGUAGE plpgsql IMMUTABLE
                    PARALLEL SAFE;