package com.alienlab.university.service;

import com.alienlab.university.domain.CourseGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
     *
     *  @return the list of entities
     */
    List<CourseGroup> findAll();

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
