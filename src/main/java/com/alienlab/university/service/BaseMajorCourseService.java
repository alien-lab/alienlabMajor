package com.alienlab.university.service;

import com.alienlab.university.domain.BaseMajorCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseMajorCourse.
 */
public interface BaseMajorCourseService {

    /**
     * Save a baseMajorCourse.
     *
     * @param baseMajorCourse the entity to save
     * @return the persisted entity
     */
    BaseMajorCourse save(BaseMajorCourse baseMajorCourse);

    /**
     *  Get all the baseMajorCourses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseMajorCourse> findAll(Pageable pageable);

    /**
     *  Get the "id" baseMajorCourse.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseMajorCourse findOne(Long id);

    /**
     *  Delete the "id" baseMajorCourse.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
