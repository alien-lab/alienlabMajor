package com.alienlab.university.service.impl;

import com.alienlab.university.service.CourseGroupItemService;
import com.alienlab.university.domain.CourseGroupItem;
import com.alienlab.university.repository.CourseGroupItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing CourseGroupItem.
 */
@Service
@Transactional
public class CourseGroupItemServiceImpl implements CourseGroupItemService{

    private final Logger log = LoggerFactory.getLogger(CourseGroupItemServiceImpl.class);

    private final CourseGroupItemRepository courseGroupItemRepository;

    public CourseGroupItemServiceImpl(CourseGroupItemRepository courseGroupItemRepository) {
        this.courseGroupItemRepository = courseGroupItemRepository;
    }

    /**
     * Save a courseGroupItem.
     *
     * @param courseGroupItem the entity to save
     * @return the persisted entity
     */
    @Override
    public CourseGroupItem save(CourseGroupItem courseGroupItem) {
        log.debug("Request to save CourseGroupItem : {}", courseGroupItem);
        return courseGroupItemRepository.save(courseGroupItem);
    }

    /**
     *  Get all the courseGroupItems.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CourseGroupItem> findAll(Pageable pageable) {
        log.debug("Request to get all CourseGroupItems");
        return courseGroupItemRepository.findAll(pageable);
    }

    /**
     *  Get one courseGroupItem by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CourseGroupItem findOne(Long id) {
        log.debug("Request to get CourseGroupItem : {}", id);
        return courseGroupItemRepository.findOne(id);
    }

    /**
     *  Delete the  courseGroupItem by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseGroupItem : {}", id);
        courseGroupItemRepository.delete(id);
    }
}
