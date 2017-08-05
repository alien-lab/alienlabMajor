package com.alienlab.university.service;

import com.alienlab.university.domain.BaseMajor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseMajor.
 */
public interface BaseMajorService {

    /**
     * Save a baseMajor.
     *
     * @param baseMajor the entity to save
     * @return the persisted entity
     */
    BaseMajor save(BaseMajor baseMajor);

    /**
     *  Get all the baseMajors.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseMajor> findAll(Pageable pageable);

    /**
     *  Get the "id" baseMajor.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseMajor findOne(Long id);

    /**
     *  Delete the "id" baseMajor.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
