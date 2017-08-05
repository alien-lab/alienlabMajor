package com.alienlab.university.service.impl;

import com.alienlab.university.service.TraningStructService;
import com.alienlab.university.domain.TraningStruct;
import com.alienlab.university.repository.TraningStructRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing TraningStruct.
 */
@Service
@Transactional
public class TraningStructServiceImpl implements TraningStructService{

    private final Logger log = LoggerFactory.getLogger(TraningStructServiceImpl.class);

    private final TraningStructRepository traningStructRepository;

    public TraningStructServiceImpl(TraningStructRepository traningStructRepository) {
        this.traningStructRepository = traningStructRepository;
    }

    /**
     * Save a traningStruct.
     *
     * @param traningStruct the entity to save
     * @return the persisted entity
     */
    @Override
    public TraningStruct save(TraningStruct traningStruct) {
        log.debug("Request to save TraningStruct : {}", traningStruct);
        return traningStructRepository.save(traningStruct);
    }

    /**
     *  Get all the traningStructs.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TraningStruct> findAll(Pageable pageable) {
        log.debug("Request to get all TraningStructs");
        return traningStructRepository.findAll(pageable);
    }

    /**
     *  Get one traningStruct by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TraningStruct findOne(Long id) {
        log.debug("Request to get TraningStruct : {}", id);
        return traningStructRepository.findOne(id);
    }

    /**
     *  Delete the  traningStruct by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TraningStruct : {}", id);
        traningStructRepository.delete(id);
    }
}
