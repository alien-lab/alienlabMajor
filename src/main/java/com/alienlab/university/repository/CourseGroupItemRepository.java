package com.alienlab.university.repository;

import com.alienlab.university.domain.CourseGroupItem;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CourseGroupItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseGroupItemRepository extends JpaRepository<CourseGroupItem,Long> {
    
}
