package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseTeacher;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseTeacher entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseTeacherRepository extends JpaRepository<BaseTeacher,Long> {
    
}
