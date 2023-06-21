CREATE OR REPLACE FUNCTION check_amount_criteria(IN i_criteria TEXT) RETURNS BOOLEAN AS
$$
BEGIN
	RETURN i_criteria IN (
	                      'LESS',
	                      'LESS_OR_EQUAL',
	                      'GREATER',
	                      'GREATER_OR_EQUAL',
	                      'EQUAL'
		);
END;
$$ LANGUAGE plpgsql IMMUTABLE
                    PARALLEL SAFE;