package com.alienlab.university.service.impl;

import com.alienlab.university.service.TraningDataService;
import com.alienlab.university.domain.TraningData;
import com.alienlab.university.repository.TraningDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing TraningData.
 */
@Service
@Transactional
public class TraningDataServiceImpl implements TraningDataService{

    private final Logger log = LoggerFactory.getLogger(TraningDataServiceImpl.class);

    private final TraningDataRepository traningDataRepository;

    public TraningDataServiceImpl(TraningDataRepository traningDataRepository) {
        this.traningDataRepository = traningDataRepository;
    }

    /**
     * Save a traningData.
     *
     * @param traningData the entity to save
     * @return the persisted entity
     */
    @Override
    public TraningData save(TraningData traningData) {
        log.debug("Request to save TraningData : {}", traningData);
        return traningDataRepository.save(traningData);
    }

    /**
     *  Get all the traningData.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TraningData> findAll(Pageable pageable) {
        log.debug("Request to get all TraningData");
        return traningDataRepository.findAll(pageable);
    }

    /**
     *  Get one traningData by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TraningData findOne(Long id) {
        log.debug("Request to get TraningData : {}", id);
        return traningDataRepository.findOne(id);
    }

    /**
     *  Delete the  traningData by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TraningData : {}", id);
        traningDataRepository.delete(id);
    }
}
