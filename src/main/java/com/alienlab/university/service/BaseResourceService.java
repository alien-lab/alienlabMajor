package com.alienlab.university.service;

import com.alienlab.university.domain.BaseResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseResource.
 */
public interface BaseResourceService {

    /**
     * Save a baseResource.
     *
     * @param baseResource the entity to save
     * @return the persisted entity
     */
    BaseResource save(BaseResource baseResource);

    /**
     *  Get all the baseResources.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseResource> findAll(Pageable pageable);

    /**
     *  Get the "id" baseResource.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseResource findOne(Long id);

    /**
     *  Delete the "id" baseResource.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
