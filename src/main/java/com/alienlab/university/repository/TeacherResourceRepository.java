package com.alienlab.university.repository;

import com.alienlab.university.domain.TeacherResource;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TeacherResource entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TeacherResourceRepository extends JpaRepository<TeacherResource,Long> {
    
}
