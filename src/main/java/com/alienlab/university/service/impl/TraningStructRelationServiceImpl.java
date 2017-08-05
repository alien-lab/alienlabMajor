package com.alienlab.university.service.impl;

import com.alienlab.university.service.TraningStructRelationService;
import com.alienlab.university.domain.TraningStructRelation;
import com.alienlab.university.repository.TraningStructRelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing TraningStructRelation.
 */
@Service
@Transactional
public class TraningStructRelationServiceImpl implements TraningStructRelationService{

    private final Logger log = LoggerFactory.getLogger(TraningStructRelationServiceImpl.class);

    private final TraningStructRelationRepository traningStructRelationRepository;

    public TraningStructRelationServiceImpl(TraningStructRelationRepository traningStructRelationRepository) {
        this.traningStructRelationRepository = traningStructRelationRepository;
    }

    /**
     * Save a traningStructRelation.
     *
     * @param traningStructRelation the entity to save
     * @return the persisted entity
     */
    @Override
    public TraningStructRelation save(TraningStructRelation traningStructRelation) {
        log.debug("Request to save TraningStructRelation : {}", traningStructRelation);
        return traningStructRelationRepository.save(traningStructRelation);
    }

    /**
     *  Get all the traningStructRelations.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TraningStructRelation> findAll(Pageable pageable) {
        log.debug("Request to get all TraningStructRelations");
        return traningStructRelationRepository.findAll(pageable);
    }

    /**
     *  Get one traningStructRelation by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TraningStructRelation findOne(Long id) {
        log.debug("Request to get TraningStructRelation : {}", id);
        return traningStructRelationRepository.findOne(id);
    }

    /**
     *  Delete the  traningStructRelation by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TraningStructRelation : {}", id);
        traningStructRelationRepository.delete(id);
    }
}
