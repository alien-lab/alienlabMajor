package com.alienlab.university.service;

import com.alienlab.university.domain.TraningStruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing TraningStruct.
 */
public interface TraningStructService {

    /**
     * Save a traningStruct.
     *
     * @param traningStruct the entity to save
     * @return the persisted entity
     */
    TraningStruct save(TraningStruct traningStruct);

    /**
     *  Get all the traningStructs.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<TraningStruct> findAll(Pageable pageable);

    /**
     *  Get the "id" traningStruct.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TraningStruct findOne(Long id);

    /**
     *  Delete the "id" traningStruct.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
