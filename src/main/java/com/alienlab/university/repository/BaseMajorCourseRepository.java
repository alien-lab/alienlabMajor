package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseMajorCourse;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseMajorCourse entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseMajorCourseRepository extends JpaRepository<BaseMajorCourse,Long> {
    
}
