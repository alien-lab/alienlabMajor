package com.alienlab.university.repository;

import com.alienlab.university.domain.TeacherComment;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TeacherComment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TeacherCommentRepository extends JpaRepository<TeacherComment,Long> {
    
}
