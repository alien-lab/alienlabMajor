package com.alienlab.university.service;

import com.alienlab.university.domain.ResourceComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing ResourceComment.
 */
public interface ResourceCommentService {

    /**
     * Save a resourceComment.
     *
     * @param resourceComment the entity to save
     * @return the persisted entity
     */
    ResourceComment save(ResourceComment resourceComment);

    /**
     *  Get all the resourceComments.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ResourceComment> findAll(Pageable pageable);

    /**
     *  Get the "id" resourceComment.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ResourceComment findOne(Long id);

    /**
     *  Delete the "id" resourceComment.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
