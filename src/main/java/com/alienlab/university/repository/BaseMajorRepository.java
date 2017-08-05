package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseMajor;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseMajor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseMajorRepository extends JpaRepository<BaseMajor,Long> {
    
}
