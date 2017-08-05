package com.alienlab.university.service;

import com.alienlab.university.domain.BaseTerm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseTerm.
 */
public interface BaseTermService {

    /**
     * Save a baseTerm.
     *
     * @param baseTerm the entity to save
     * @return the persisted entity
     */
    BaseTerm save(BaseTerm baseTerm);

    /**
     *  Get all the baseTerms.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseTerm> findAll(Pageable pageable);

    /**
     *  Get the "id" baseTerm.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseTerm findOne(Long id);

    /**
     *  Delete the "id" baseTerm.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
