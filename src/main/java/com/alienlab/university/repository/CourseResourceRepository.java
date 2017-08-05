package com.alienlab.university.repository;

import com.alienlab.university.domain.CourseResource;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CourseResource entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseResourceRepository extends JpaRepository<CourseResource,Long> {
    
}
