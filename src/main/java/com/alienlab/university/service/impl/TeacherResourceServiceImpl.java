package com.alienlab.university.service.impl;

import com.alienlab.university.service.TeacherResourceService;
import com.alienlab.university.domain.TeacherResource;
import com.alienlab.university.repository.TeacherResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing TeacherResource.
 */
@Service
@Transactional
public class TeacherResourceServiceImpl implements TeacherResourceService{

    private final Logger log = LoggerFactory.getLogger(TeacherResourceServiceImpl.class);

    private final TeacherResourceRepository teacherResourceRepository;

    public TeacherResourceServiceImpl(TeacherResourceRepository teacherResourceRepository) {
        this.teacherResourceRepository = teacherResourceRepository;
    }

    /**
     * Save a teacherResource.
     *
     * @param teacherResource the entity to save
     * @return the persisted entity
     */
    @Override
    public TeacherResource save(TeacherResource teacherResource) {
        log.debug("Request to save TeacherResource : {}", teacherResource);
        return teacherResourceRepository.save(teacherResource);
    }

    /**
     *  Get all the teacherResources.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TeacherResource> findAll(Pageable pageable) {
        log.debug("Request to get all TeacherResources");
        return teacherResourceRepository.findAll(pageable);
    }

    /**
     *  Get one teacherResource by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TeacherResource findOne(Long id) {
        log.debug("Request to get TeacherResource : {}", id);
        return teacherResourceRepository.findOne(id);
    }

    /**
     *  Delete the  teacherResource by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TeacherResource : {}", id);
        teacherResourceRepository.delete(id);
    }
}
