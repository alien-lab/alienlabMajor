package com.alienlab.university.service;

import com.alienlab.university.domain.CourseTree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseTree.
 */
public interface CourseTreeService {

    /**
     * Save a courseTree.
     *
     * @param courseTree the entity to save
     * @return the persisted entity
     */
    CourseTree save(CourseTree courseTree);

    /**
     *  Get all the courseTrees.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseTree> findAll(Pageable pageable);

    /**
     *  Get the "id" courseTree.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseTree findOne(Long id);

    /**
     *  Delete the "id" courseTree.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
