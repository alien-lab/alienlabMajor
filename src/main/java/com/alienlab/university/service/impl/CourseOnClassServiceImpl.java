package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseOnClassService;
import com.alienlab.university.domain.CourseOnClass;
import com.alienlab.university.repository.CourseOnClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseOnClass.
 */
@Service
@Transactional
public class CourseOnClassServiceImpl implements CourseOnClassService{

    private final Logger log = LoggerFactory.getLogger(CourseOnClassServiceImpl.class);

    private final CourseOnClassRepository courseOnClassRepository;

    public CourseOnClassServiceImpl(CourseOnClassRepository courseOnClassRepository) {
        this.courseOnClassRepository = courseOnClassRepository;
    }

    /**
     * Save a courseOnClass.
     *
     * @param courseOnClass the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseOnClass save(CourseOnClass courseOnClass) {
        log.debug("Request to save CourseOnClass : {}", courseOnClass);
        return courseOnClassRepository.save(courseOnClass);
    }

    /**
     *  Get all the courseOnClasses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseOnClass> findAll(Pageable pageable) {
        log.debug("Request to get all CourseOnClasses");
        return courseOnClassRepository.findAll(pageable);
    }

    /**
     *  Get one courseOnClass by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseOnClass findOne(Long id) {
        log.debug("Request to get CourseOnClass : {}", id);
        return courseOnClassRepository.findOne(id);
    }

    /**
     *  Delete the  courseOnClass by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseOnClass : {}", id);
        courseOnClassRepository.delete(id);
    }
}
