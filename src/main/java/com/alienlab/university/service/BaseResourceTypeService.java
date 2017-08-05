package com.alienlab.university.service;

import com.alienlab.university.domain.BaseResourceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseResourceType.
 */
public interface BaseResourceTypeService {

    /**
     * Save a baseResourceType.
     *
     * @param baseResourceType the entity to save
     * @return the persisted entity
     */
    BaseResourceType save(BaseResourceType baseResourceType);

    /**
     *  Get all the baseResourceTypes.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseResourceType> findAll(Pageable pageable);

    /**
     *  Get the "id" baseResourceType.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseResourceType findOne(Long id);

    /**
     *  Delete the "id" baseResourceType.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
