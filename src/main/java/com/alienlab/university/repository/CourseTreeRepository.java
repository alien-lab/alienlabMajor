package com.alienlab.university.repository;

import com.alienlab.university.domain.CourseTree;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CourseTree entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseTreeRepository extends JpaRepository<CourseTree,Long> {
    
}
