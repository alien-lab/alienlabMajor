package com.alienlab.university.service;

import com.alienlab.university.domain.BaseDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing BaseDepartment.
 */
public interface BaseDepartmentService {

    /**
     * Save a baseDepartment.
     *
     * @param baseDepartment the entity to save
     * @return the persisted entity
     */
    BaseDepartment save(BaseDepartment baseDepartment);

    /**
     *  Get all the baseDepartments.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<BaseDepartment> findAll(Pageable pageable);

    /**
     *  Get the "id" baseDepartment.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    BaseDepartment findOne(Long id);

    /**
     *  Delete the "id" baseDepartment.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
