package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseGroupService;
import com.alienlab.university.domain.CourseGroup;
import com.alienlab.university.repository.CourseGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseGroup.
 */
@Service
@Transactional
public class CourseGroupServiceImpl implements CourseGroupService{

    private final Logger log = LoggerFactory.getLogger(CourseGroupServiceImpl.class);

    private final CourseGroupRepository courseGroupRepository;

    public CourseGroupServiceImpl(CourseGroupRepository courseGroupRepository) {
        this.courseGroupRepository = courseGroupRepository;
    }

    /**
     * Save a courseGroup.
     *
     * @param courseGroup the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseGroup save(CourseGroup courseGroup) {
        log.debug("Request to save CourseGroup : {}", courseGroup);
        return courseGroupRepository.save(courseGroup);
    }

    /**
     *  Get all the courseGroups.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseGroup> findAll(Pageable pageable) {
        log.debug("Request to get all CourseGroups");
        return courseGroupRepository.findAll(pageable);
    }

    /**
     *  Get one courseGroup by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseGroup findOne(Long id) {
        log.debug("Request to get CourseGroup : {}", id);
        return courseGroupRepository.findOne(id);
    }

    /**
     *  Delete the  courseGroup by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseGroup : {}", id);
        courseGroupRepository.delete(id);
    }
}
