package com.alienlab.university.service;

import com.alienlab.university.domain.CourseOnClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseOnClass.
 */
public interface CourseOnClassService {

    /**
     * Save a courseOnClass.
     *
     * @param courseOnClass the entity to save
     * @return the persisted entity
     */
    CourseOnClass save(CourseOnClass courseOnClass);

    /**
     *  Get all the courseOnClasses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseOnClass> findAll(Pageable pageable);

    /**
     *  Get the "id" courseOnClass.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseOnClass findOne(Long id);

    /**
     *  Delete the "id" courseOnClass.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
