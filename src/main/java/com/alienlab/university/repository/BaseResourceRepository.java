package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseResource;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseResource entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseResourceRepository extends JpaRepository<BaseResource,Long> {
    
}
