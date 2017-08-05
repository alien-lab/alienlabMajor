package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseVersionService;
import com.alienlab.university.domain.CourseVersion;
import com.alienlab.university.repository.CourseVersionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseVersion.
 */
@Service
@Transactional
public class CourseVersionServiceImpl implements CourseVersionService{

    private final Logger log = LoggerFactory.getLogger(CourseVersionServiceImpl.class);

    private final CourseVersionRepository courseVersionRepository;

    public CourseVersionServiceImpl(CourseVersionRepository courseVersionRepository) {
        this.courseVersionRepository = courseVersionRepository;
    }

    /**
     * Save a courseVersion.
     *
     * @param courseVersion the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseVersion save(CourseVersion courseVersion) {
        log.debug("Request to save CourseVersion : {}", courseVersion);
        return courseVersionRepository.save(courseVersion);
    }

    /**
     *  Get all the courseVersions.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseVersion> findAll(Pageable pageable) {
        log.debug("Request to get all CourseVersions");
        return courseVersionRepository.findAll(pageable);
    }

    /**
     *  Get one courseVersion by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseVersion findOne(Long id) {
        log.debug("Request to get CourseVersion : {}", id);
        return courseVersionRepository.findOne(id);
    }

    /**
     *  Delete the  courseVersion by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseVersion : {}", id);
        courseVersionRepository.delete(id);
    }
}
