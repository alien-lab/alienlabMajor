package com.alienlab.university.service.impl;

import com.alienlab.university.service.ResourceCommentService;
import com.alienlab.university.domain.ResourceComment;
import com.alienlab.university.repository.ResourceCommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing ResourceComment.
 */
@Service
@Transactional
public class ResourceCommentServiceImpl implements ResourceCommentService{

    private final Logger log = LoggerFactory.getLogger(ResourceCommentServiceImpl.class);

    private final ResourceCommentRepository resourceCommentRepository;

    public ResourceCommentServiceImpl(ResourceCommentRepository resourceCommentRepository) {
        this.resourceCommentRepository = resourceCommentRepository;
    }

    /**
     * Save a resourceComment.
     *
     * @param resourceComment the entity to save
     * @return the persisted entity
     */
    @Override
    public ResourceComment save(ResourceComment resourceComment) {
        log.debug("Request to save ResourceComment : {}", resourceComment);
        return resourceCommentRepository.save(resourceComment);
    }

    /**
     *  Get all the resourceComments.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ResourceComment> findAll(Pageable pageable) {
        log.debug("Request to get all ResourceComments");
        return resourceCommentRepository.findAll(pageable);
    }

    /**
     *  Get one resourceComment by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ResourceComment findOne(Long id) {
        log.debug("Request to get ResourceComment : {}", id);
        return resourceCommentRepository.findOne(id);
    }

    /**
     *  Delete the  resourceComment by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ResourceComment : {}", id);
        resourceCommentRepository.delete(id);
    }
}
