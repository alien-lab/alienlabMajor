package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseMajorCourseService;
import com.alienlab.university.domain.BaseMajorCourse;
import com.alienlab.university.repository.BaseMajorCourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseMajorCourse.
 */
@Service
@Transactional
public class BaseMajorCourseServiceImpl implements BaseMajorCourseService{

    private final Logger log = LoggerFactory.getLogger(BaseMajorCourseServiceImpl.class);

    private final BaseMajorCourseRepository baseMajorCourseRepository;

    public BaseMajorCourseServiceImpl(BaseMajorCourseRepository baseMajorCourseRepository) {
        this.baseMajorCourseRepository = baseMajorCourseRepository;
    }

    /**
     * Save a baseMajorCourse.
     *
     * @param baseMajorCourse the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseMajorCourse save(BaseMajorCourse baseMajorCourse) {
        log.debug("Request to save BaseMajorCourse : {}", baseMajorCourse);
        return baseMajorCourseRepository.save(baseMajorCourse);
    }

    /**
     *  Get all the baseMajorCourses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseMajorCourse> findAll(Pageable pageable) {
        log.debug("Request to get all BaseMajorCourses");
        return baseMajorCourseRepository.findAll(pageable);
    }

    /**
     *  Get one baseMajorCourse by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseMajorCourse findOne(Long id) {
        log.debug("Request to get BaseMajorCourse : {}", id);
        return baseMajorCourseRepository.findOne(id);
    }

    /**
     *  Delete the  baseMajorCourse by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseMajorCourse : {}", id);
        baseMajorCourseRepository.delete(id);
    }
}
