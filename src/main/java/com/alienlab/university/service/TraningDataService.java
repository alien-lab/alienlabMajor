package com.alienlab.university.service;

import com.alienlab.university.domain.TraningData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing TraningData.
 */
public interface TraningDataService {

    /**
     * Save a traningData.
     *
     * @param traningData the entity to save
     * @return the persisted entity
     */
    TraningData save(TraningData traningData);

    /**
     *  Get all the traningData.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<TraningData> findAll(Pageable pageable);

    /**
     *  Get the "id" traningData.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TraningData findOne(Long id);

    /**
     *  Delete the "id" traningData.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
