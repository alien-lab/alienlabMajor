package com.alienlab.university.repository;

import com.alienlab.university.domain.CourseStruct;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CourseStruct entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseStructRepository extends JpaRepository<CourseStruct,Long> {
    
}
