package com.alienlab.university.service;

import com.alienlab.university.domain.TraningStructRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing TraningStructRelation.
 */
public interface TraningStructRelationService {

    /**
     * Save a traningStructRelation.
     *
     * @param traningStructRelation the entity to save
     * @return the persisted entity
     */
    TraningStructRelation save(TraningStructRelation traningStructRelation);

    /**
     *  Get all the traningStructRelations.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<TraningStructRelation> findAll(Pageable pageable);

    /**
     *  Get the "id" traningStructRelation.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TraningStructRelation findOne(Long id);

    /**
     *  Delete the "id" traningStructRelation.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
