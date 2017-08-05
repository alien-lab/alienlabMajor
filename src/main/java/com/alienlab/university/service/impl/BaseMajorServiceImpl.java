package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseMajorService;
import com.alienlab.university.domain.BaseMajor;
import com.alienlab.university.repository.BaseMajorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseMajor.
 */
@Service
@Transactional
public class BaseMajorServiceImpl implements BaseMajorService{

    private final Logger log = LoggerFactory.getLogger(BaseMajorServiceImpl.class);

    private final BaseMajorRepository baseMajorRepository;

    public BaseMajorServiceImpl(BaseMajorRepository baseMajorRepository) {
        this.baseMajorRepository = baseMajorRepository;
    }

    /**
     * Save a baseMajor.
     *
     * @param baseMajor the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseMajor save(BaseMajor baseMajor) {
        log.debug("Request to save BaseMajor : {}", baseMajor);
        return baseMajorRepository.save(baseMajor);
    }

    /**
     *  Get all the baseMajors.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseMajor> findAll(Pageable pageable) {
        log.debug("Request to get all BaseMajors");
        return baseMajorRepository.findAll(pageable);
    }

    /**
     *  Get one baseMajor by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseMajor findOne(Long id) {
        log.debug("Request to get BaseMajor : {}", id);
        return baseMajorRepository.findOne(id);
    }

    /**
     *  Delete the  baseMajor by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseMajor : {}", id);
        baseMajorRepository.delete(id);
    }
}
