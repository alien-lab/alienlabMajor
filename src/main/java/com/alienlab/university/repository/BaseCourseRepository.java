package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseCourse;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseCourse entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseCourseRepository extends JpaRepository<BaseCourse,Long> {
    
}
