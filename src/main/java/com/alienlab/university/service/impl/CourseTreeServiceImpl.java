package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseTreeService;
import com.alienlab.university.domain.CourseTree;
import com.alienlab.university.repository.CourseTreeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseTree.
 */
@Service
@Transactional
public class CourseTreeServiceImpl implements CourseTreeService{

    private final Logger log = LoggerFactory.getLogger(CourseTreeServiceImpl.class);

    private final CourseTreeRepository courseTreeRepository;

    public CourseTreeServiceImpl(CourseTreeRepository courseTreeRepository) {
        this.courseTreeRepository = courseTreeRepository;
    }

    /**
     * Save a courseTree.
     *
     * @param courseTree the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseTree save(CourseTree courseTree) {
        log.debug("Request to save CourseTree : {}", courseTree);
        return courseTreeRepository.save(courseTree);
    }

    /**
     *  Get all the courseTrees.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseTree> findAll(Pageable pageable) {
        log.debug("Request to get all CourseTrees");
        return courseTreeRepository.findAll(pageable);
    }

    /**
     *  Get one courseTree by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseTree findOne(Long id) {
        log.debug("Request to get CourseTree : {}", id);
        return courseTreeRepository.findOne(id);
    }

    /**
     *  Delete the  courseTree by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseTree : {}", id);
        courseTreeRepository.delete(id);
    }
}
