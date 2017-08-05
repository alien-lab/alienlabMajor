package com.alienlab.university.service;

import com.alienlab.university.domain.TeacherComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing TeacherComment.
 */
public interface TeacherCommentService {

    /**
     * Save a teacherComment.
     *
     * @param teacherComment the entity to save
     * @return the persisted entity
     */
    TeacherComment save(TeacherComment teacherComment);

    /**
     *  Get all the teacherComments.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<TeacherComment> findAll(Pageable pageable);

    /**
     *  Get the "id" teacherComment.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TeacherComment findOne(Long id);

    /**
     *  Delete the "id" teacherComment.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
