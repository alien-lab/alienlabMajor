package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseResourceService;
import com.alienlab.university.domain.BaseResource;
import com.alienlab.university.repository.BaseResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseResource.
 */
@Service
@Transactional
public class BaseResourceServiceImpl implements BaseResourceService{

    private final Logger log = LoggerFactory.getLogger(BaseResourceServiceImpl.class);

    private final BaseResourceRepository baseResourceRepository;

    public BaseResourceServiceImpl(BaseResourceRepository baseResourceRepository) {
        this.baseResourceRepository = baseResourceRepository;
    }

    /**
     * Save a baseResource.
     *
     * @param baseResource the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseResource save(BaseResource baseResource) {
        log.debug("Request to save BaseResource : {}", baseResource);
        return baseResourceRepository.save(baseResource);
    }

    /**
     *  Get all the baseResources.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseResource> findAll(Pageable pageable) {
        log.debug("Request to get all BaseResources");
        return baseResourceRepository.findAll(pageable);
    }

    /**
     *  Get one baseResource by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseResource findOne(Long id) {
        log.debug("Request to get BaseResource : {}", id);
        return baseResourceRepository.findOne(id);
    }

    /**
     *  Delete the  baseResource by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseResource : {}", id);
        baseResourceRepository.delete(id);
    }
}
