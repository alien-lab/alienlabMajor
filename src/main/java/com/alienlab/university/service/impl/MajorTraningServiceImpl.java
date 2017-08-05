package com.alienlab.university.service.impl;

import com.alienlab.university.service.MajorTraningService;
import com.alienlab.university.domain.MajorTraning;
import com.alienlab.university.repository.MajorTraningRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing MajorTraning.
 */
@Service
@Transactional
public class MajorTraningServiceImpl implements MajorTraningService{

    private final Logger log = LoggerFactory.getLogger(MajorTraningServiceImpl.class);

    private final MajorTraningRepository majorTraningRepository;

    public MajorTraningServiceImpl(MajorTraningRepository majorTraningRepository) {
        this.majorTraningRepository = majorTraningRepository;
    }

    /**
     * Save a majorTraning.
     *
     * @param majorTraning the entity to save
     * @return the persisted entity
     */
    @Override
    public MajorTraning save(MajorTraning majorTraning) {
        log.debug("Request to save MajorTraning : {}", majorTraning);
        return majorTraningRepository.save(majorTraning);
    }

    /**
     *  Get all the majorTranings.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MajorTraning> findAll(Pageable pageable) {
        log.debug("Request to get all MajorTranings");
        return majorTraningRepository.findAll(pageable);
    }

    /**
     *  Get one majorTraning by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public MajorTraning findOne(Long id) {
        log.debug("Request to get MajorTraning : {}", id);
        return majorTraningRepository.findOne(id);
    }

    /**
     *  Delete the  majorTraning by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MajorTraning : {}", id);
        majorTraningRepository.delete(id);
    }
}
