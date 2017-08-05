package com.alienlab.university.repository;

import com.alienlab.university.domain.TraningData;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TraningData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TraningDataRepository extends JpaRepository<TraningData,Long> {
    
}
