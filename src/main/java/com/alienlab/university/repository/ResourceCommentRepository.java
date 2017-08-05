package com.alienlab.university.repository;

import com.alienlab.university.domain.ResourceComment;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ResourceComment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResourceCommentRepository extends JpaRepository<ResourceComment,Long> {
    
}
