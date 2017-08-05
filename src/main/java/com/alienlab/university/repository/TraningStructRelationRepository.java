package com.alienlab.university.repository;

import com.alienlab.university.domain.TraningStructRelation;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TraningStructRelation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TraningStructRelationRepository extends JpaRepository<TraningStructRelation,Long> {
    
}
