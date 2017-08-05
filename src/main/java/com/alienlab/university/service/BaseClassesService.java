package com.alienlab.university.service;

import com.alienlab.university.domain.BaseClasses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseClasses.
 */
public interface BaseClassesService {

    /**
     * Save a baseClasses.
     *
     * @param baseClasses the entity to save
     * @return the persisted entity
     */
    BaseClasses save(BaseClasses baseClasses);

    /**
     *  Get all the baseClasses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseClasses> findAll(Pageable pageable);

    /**
     *  Get the "id" baseClasses.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseClasses findOne(Long id);

    /**
     *  Delete the "id" baseClasses.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
