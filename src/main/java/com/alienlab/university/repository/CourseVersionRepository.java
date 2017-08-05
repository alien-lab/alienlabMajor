package com.alienlab.university.repository;

import com.alienlab.university.domain.CourseVersion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CourseVersion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseVersionRepository extends JpaRepository<CourseVersion,Long> {
    
}
