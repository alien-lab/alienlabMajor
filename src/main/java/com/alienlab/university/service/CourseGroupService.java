package com.alienlab.university.service;

import com.alienlab.university.domain.CourseGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseGroup.
 */
public interface CourseGroupService {

    /**
     * Save a courseGroup.
     *
     * @param courseGroup the entity to save
     * @return the persisted entity
     */
    CourseGroup save(CourseGroup courseGroup);

    /**
     *  Get all the courseGroups.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseGroup> findAll(Pageable pageable);

    /**
     *  Get the "id" courseGroup.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseGroup findOne(Long id);

    /**
     *  Delete the "id" courseGroup.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
