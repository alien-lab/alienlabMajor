package com.alienlab.university.service;

import com.alienlab.university.domain.MajorTraning;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing MajorTraning.
 */
public interface MajorTraningService {

    /**
     * Save a majorTraning.
     *
     * @param majorTraning the entity to save
     * @return the persisted entity
     */
    MajorTraning save(MajorTraning majorTraning);

    /**
     *  Get all the majorTranings.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<MajorTraning> findAll(Pageable pageable);

    /**
     *  Get the "id" majorTraning.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    MajorTraning findOne(Long id);

    /**
     *  Delete the "id" majorTraning.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
