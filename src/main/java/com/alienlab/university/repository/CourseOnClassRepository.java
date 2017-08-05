package com.alienlab.university.repository;

import com.alienlab.university.domain.CourseOnClass;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CourseOnClass entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseOnClassRepository extends JpaRepository<CourseOnClass,Long> {
    
}
