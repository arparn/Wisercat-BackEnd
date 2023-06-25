package com.wisercat.backend.repository;

import com.wisercat.backend.db.enums.FilterType;
import com.wisercat.backend.db.model.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {

	@Modifying
	@Query("update Filter f set f.name = :name where f.id = :id")
	void update(@Param("id") Long id, @Param("name") String name);

	List<Filter> findAllByFilterType(@Param("filterType") FilterType filterType);
}
