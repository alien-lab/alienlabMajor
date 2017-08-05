package com.alienlab.university.service;

import com.alienlab.university.domain.TeacherResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing TeacherResource.
 */
public interface TeacherResourceService {

    /**
     * Save a teacherResource.
     *
     * @param teacherResource the entity to save
     * @return the persisted entity
     */
    TeacherResource save(TeacherResource teacherResource);

    /**
     *  Get all the teacherResources.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<TeacherResource> findAll(Pageable pageable);

    /**
     *  Get the "id" teacherResource.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TeacherResource findOne(Long id);

    /**
     *  Delete the "id" teacherResource.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
