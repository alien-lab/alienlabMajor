package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseStructService;
import com.alienlab.university.domain.CourseStruct;
import com.alienlab.university.repository.CourseStructRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseStruct.
 */
@Service
@Transactional
public class CourseStructServiceImpl implements CourseStructService{

    private final Logger log = LoggerFactory.getLogger(CourseStructServiceImpl.class);

    private final CourseStructRepository courseStructRepository;

    public CourseStructServiceImpl(CourseStructRepository courseStructRepository) {
        this.courseStructRepository = courseStructRepository;
    }

    /**
     * Save a courseStruct.
     *
     * @param courseStruct the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseStruct save(CourseStruct courseStruct) {
        log.debug("Request to save CourseStruct : {}", courseStruct);
        return courseStructRepository.save(courseStruct);
    }

    /**
     *  Get all the courseStructs.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseStruct> findAll(Pageable pageable) {
        log.debug("Request to get all CourseStructs");
        return courseStructRepository.findAll(pageable);
    }

    /**
     *  Get one courseStruct by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseStruct findOne(Long id) {
        log.debug("Request to get CourseStruct : {}", id);
        return courseStructRepository.findOne(id);
    }

    /**
     *  Delete the  courseStruct by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseStruct : {}", id);
        courseStructRepository.delete(id);
    }
}
