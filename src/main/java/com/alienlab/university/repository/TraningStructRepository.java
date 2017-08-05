package com.alienlab.university.repository;

import com.alienlab.university.domain.TraningStruct;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TraningStruct entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TraningStructRepository extends JpaRepository<TraningStruct,Long> {
    
}
