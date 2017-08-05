package com.alienlab.university.service;

import com.alienlab.university.domain.CourseStruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseStruct.
 */
public interface CourseStructService {

    /**
     * Save a courseStruct.
     *
     * @param courseStruct the entity to save
     * @return the persisted entity
     */
    CourseStruct save(CourseStruct courseStruct);

    /**
     *  Get all the courseStructs.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseStruct> findAll(Pageable pageable);

    /**
     *  Get the "id" courseStruct.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseStruct findOne(Long id);

    /**
     *  Delete the "id" courseStruct.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
