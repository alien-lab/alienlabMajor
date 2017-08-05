package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseClassesService;
import com.alienlab.university.domain.BaseClasses;
import com.alienlab.university.repository.BaseClassesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseClasses.
 */
@Service
@Transactional
public class BaseClassesServiceImpl implements BaseClassesService{

    private final Logger log = LoggerFactory.getLogger(BaseClassesServiceImpl.class);

    private final BaseClassesRepository baseClassesRepository;

    public BaseClassesServiceImpl(BaseClassesRepository baseClassesRepository) {
        this.baseClassesRepository = baseClassesRepository;
    }

    /**
     * Save a baseClasses.
     *
     * @param baseClasses the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseClasses save(BaseClasses baseClasses) {
        log.debug("Request to save BaseClasses : {}", baseClasses);
        return baseClassesRepository.save(baseClasses);
    }

    /**
     *  Get all the baseClasses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseClasses> findAll(Pageable pageable) {
        log.debug("Request to get all BaseClasses");
        return baseClassesRepository.findAll(pageable);
    }

    /**
     *  Get one baseClasses by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseClasses findOne(Long id) {
        log.debug("Request to get BaseClasses : {}", id);
        return baseClassesRepository.findOne(id);
    }

    /**
     *  Delete the  baseClasses by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseClasses : {}", id);
        baseClassesRepository.delete(id);
    }
}
