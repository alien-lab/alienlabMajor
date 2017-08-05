package com.alienlab.university.repository;

import com.alienlab.university.domain.CourseTalk;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CourseTalk entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseTalkRepository extends JpaRepository<CourseTalk,Long> {
    
}
