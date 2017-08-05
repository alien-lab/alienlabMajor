package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseCourseService;
import com.alienlab.university.domain.BaseCourse;
import com.alienlab.university.repository.BaseCourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseCourse.
 */
@Service
@Transactional
public class BaseCourseServiceImpl implements BaseCourseService{

    private final Logger log = LoggerFactory.getLogger(BaseCourseServiceImpl.class);

    private final BaseCourseRepository baseCourseRepository;

    public BaseCourseServiceImpl(BaseCourseRepository baseCourseRepository) {
        this.baseCourseRepository = baseCourseRepository;
    }

    /**
     * Save a baseCourse.
     *
     * @param baseCourse the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseCourse save(BaseCourse baseCourse) {
        log.debug("Request to save BaseCourse : {}", baseCourse);
        return baseCourseRepository.save(baseCourse);
    }

    /**
     *  Get all the baseCourses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseCourse> findAll(Pageable pageable) {
        log.debug("Request to get all BaseCourses");
        return baseCourseRepository.findAll(pageable);
    }

    /**
     *  Get one baseCourse by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseCourse findOne(Long id) {
        log.debug("Request to get BaseCourse : {}", id);
        return baseCourseRepository.findOne(id);
    }

    /**
     *  Delete the  baseCourse by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseCourse : {}", id);
        baseCourseRepository.delete(id);
    }
}
