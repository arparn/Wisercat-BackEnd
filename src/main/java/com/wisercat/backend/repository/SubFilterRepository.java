package com.wisercat.backend.repository;

import com.wisercat.backend.db.model.SubFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubFilterRepository extends JpaRepository<SubFilter, Long> {

	void deleteAllByFilterId(@Param("id") Long filterId);
}
