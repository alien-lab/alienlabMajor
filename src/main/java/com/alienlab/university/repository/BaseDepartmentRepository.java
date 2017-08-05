package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseDepartment;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseDepartment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseDepartmentRepository extends JpaRepository<BaseDepartment,Long> {
    
}
