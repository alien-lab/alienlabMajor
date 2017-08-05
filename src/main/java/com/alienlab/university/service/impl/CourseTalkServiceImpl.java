package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseTalkService;
import com.alienlab.university.domain.CourseTalk;
import com.alienlab.university.repository.CourseTalkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseTalk.
 */
@Service
@Transactional
public class CourseTalkServiceImpl implements CourseTalkService{

    private final Logger log = LoggerFactory.getLogger(CourseTalkServiceImpl.class);

    private final CourseTalkRepository courseTalkRepository;

    public CourseTalkServiceImpl(CourseTalkRepository courseTalkRepository) {
        this.courseTalkRepository = courseTalkRepository;
    }

    /**
     * Save a courseTalk.
     *
     * @param courseTalk the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseTalk save(CourseTalk courseTalk) {
        log.debug("Request to save CourseTalk : {}", courseTalk);
        return courseTalkRepository.save(courseTalk);
    }

    /**
     *  Get all the courseTalks.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseTalk> findAll(Pageable pageable) {
        log.debug("Request to get all CourseTalks");
        return courseTalkRepository.findAll(pageable);
    }

    /**
     *  Get one courseTalk by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseTalk findOne(Long id) {
        log.debug("Request to get CourseTalk : {}", id);
        return courseTalkRepository.findOne(id);
    }

    /**
     *  Delete the  courseTalk by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseTalk : {}", id);
        courseTalkRepository.delete(id);
    }
}
