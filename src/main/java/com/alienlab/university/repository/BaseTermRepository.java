package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseTerm;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseTerm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseTermRepository extends JpaRepository<BaseTerm,Long> {
    
}
