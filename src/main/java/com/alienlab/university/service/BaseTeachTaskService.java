package com.alienlab.university.service;

import com.alienlab.university.domain.BaseTeachTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseTeachTask.
 */
public interface BaseTeachTaskService {

    /**
     * Save a baseTeachTask.
     *
     * @param baseTeachTask the entity to save
     * @return the persisted entity
     */
    BaseTeachTask save(BaseTeachTask baseTeachTask);

    /**
     *  Get all the baseTeachTasks.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseTeachTask> findAll(Pageable pageable);

    /**
     *  Get the "id" baseTeachTask.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseTeachTask findOne(Long id);

    /**
     *  Delete the "id" baseTeachTask.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
