package com.alienlab.university.service;

import com.alienlab.university.domain.CourseTalk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing CourseTalk.
 */
public interface CourseTalkService {

    /**
     * Save a courseTalk.
     *
     * @param courseTalk the entity to save
     * @return the persisted entity
     */
    CourseTalk save(CourseTalk courseTalk);

    /**
     *  Get all the courseTalks.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<CourseTalk> findAll(Pageable pageable);

    /**
     *  Get the "id" courseTalk.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    CourseTalk findOne(Long id);

    /**
     *  Delete the "id" courseTalk.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
