package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseResourceService;
import com.alienlab.university.domain.CourseResource;
import com.alienlab.university.repository.CourseResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseResource.
 */
@Service
@Transactional
public class CourseResourceServiceImpl implements CourseResourceService{

    private final Logger log = LoggerFactory.getLogger(CourseResourceServiceImpl.class);

    private final CourseResourceRepository courseResourceRepository;

    public CourseResourceServiceImpl(CourseResourceRepository courseResourceRepository) {
        this.courseResourceRepository = courseResourceRepository;
    }

    /**
     * Save a courseResource.
     *
     * @param courseResource the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseResource save(CourseResource courseResource) {
        log.debug("Request to save CourseResource : {}", courseResource);
        return courseResourceRepository.save(courseResource);
    }

    /**
     *  Get all the courseResources.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseResource> findAll(Pageable pageable) {
        log.debug("Request to get all CourseResources");
        return courseResourceRepository.findAll(pageable);
    }

    /**
     *  Get one courseResource by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseResource findOne(Long id) {
        log.debug("Request to get CourseResource : {}", id);
        return courseResourceRepository.findOne(id);
    }

    /**
     *  Delete the  courseResource by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseResource : {}", id);
        courseResourceRepository.delete(id);
    }
}
