package com.alienlab.university.service;

import com.alienlab.university.domain.CourseGroupItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseGroupItem.
 */
public interface CourseGroupItemService {

    /**
     * Save a courseGroupItem.
     *
     * @param courseGroupItem the entity to save
     * @return the persisted entity
     */
    CourseGroupItem save(CourseGroupItem courseGroupItem);

    /**
     *  Get all the courseGroupItems.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseGroupItem> findAll(Pageable pageable);

    /**
     *  Get the "id" courseGroupItem.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseGroupItem findOne(Long id);

    /**
     *  Delete the "id" courseGroupItem.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
