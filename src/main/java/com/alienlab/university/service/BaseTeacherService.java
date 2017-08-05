package com.alienlab.university.service;

import com.alienlab.university.domain.BaseTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseTeacher.
 */
public interface BaseTeacherService {

    /**
     * Save a baseTeacher.
     *
     * @param baseTeacher the entity to save
     * @return the persisted entity
     */
    BaseTeacher save(BaseTeacher baseTeacher);

    /**
     *  Get all the baseTeachers.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseTeacher> findAll(Pageable pageable);

    /**
     *  Get the "id" baseTeacher.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseTeacher findOne(Long id);

    /**
     *  Delete the "id" baseTeacher.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
