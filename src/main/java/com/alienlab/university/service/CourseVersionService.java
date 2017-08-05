package com.alienlab.university.service;

import com.alienlab.university.domain.CourseVersion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseVersion.
 */
public interface CourseVersionService {

    /**
     * Save a courseVersion.
     *
     * @param courseVersion the entity to save
     * @return the persisted entity
     */
    CourseVersion save(CourseVersion courseVersion);

    /**
     *  Get all the courseVersions.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseVersion> findAll(Pageable pageable);

    /**
     *  Get the "id" courseVersion.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseVersion findOne(Long id);

    /**
     *  Delete the "id" courseVersion.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
