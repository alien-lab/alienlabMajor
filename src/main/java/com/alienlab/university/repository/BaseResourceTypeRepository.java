package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseResourceType;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseResourceType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseResourceTypeRepository extends JpaRepository<BaseResourceType,Long> {
    
}
