CREATE OR REPLACE FUNCTION to_upper(IN i_text DATE) RETURNS TEXT AS
$$
BEGIN
	RETURN UPPER(i_text);
END
$$ LANGUAGE plpgsql IMMUTABLE PARALLEL SAFE;