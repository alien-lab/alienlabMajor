package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseClasses;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseClasses entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseClassesRepository extends JpaRepository<BaseClasses,Long> {
    
}
