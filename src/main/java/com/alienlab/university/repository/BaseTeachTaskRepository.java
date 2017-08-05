package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseTeachTask;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BaseTeachTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseTeachTaskRepository extends JpaRepository<BaseTeachTask,Long> {
    
}
