package com.alienlab.university.service;

import com.alienlab.university.domain.CourseResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseResource.
 */
public interface CourseResourceService {

    /**
     * Save a courseResource.
     *
     * @param courseResource the entity to save
     * @return the persisted entity
     */
    CourseResource save(CourseResource courseResource);

    /**
     *  Get all the courseResources.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseResource> findAll(Pageable pageable);

    /**
     *  Get the "id" courseResource.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseResource findOne(Long id);

    /**
     *  Delete the "id" courseResource.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
