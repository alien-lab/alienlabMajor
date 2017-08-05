package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseTermService;
import com.alienlab.university.domain.BaseTerm;
import com.alienlab.university.repository.BaseTermRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseTerm.
 */
@Service
@Transactional
public class BaseTermServiceImpl implements BaseTermService{

    private final Logger log = LoggerFactory.getLogger(BaseTermServiceImpl.class);

    private final BaseTermRepository baseTermRepository;

    public BaseTermServiceImpl(BaseTermRepository baseTermRepository) {
        this.baseTermRepository = baseTermRepository;
    }

    /**
     * Save a baseTerm.
     *
     * @param baseTerm the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseTerm save(BaseTerm baseTerm) {
        log.debug("Request to save BaseTerm : {}", baseTerm);
        return baseTermRepository.save(baseTerm);
    }

    /**
     *  Get all the baseTerms.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseTerm> findAll(Pageable pageable) {
        log.debug("Request to get all BaseTerms");
        return baseTermRepository.findAll(pageable);
    }

    /**
     *  Get one baseTerm by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseTerm findOne(Long id) {
        log.debug("Request to get BaseTerm : {}", id);
        return baseTermRepository.findOne(id);
    }

    /**
     *  Delete the  baseTerm by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseTerm : {}", id);
        baseTermRepository.delete(id);
    }
}
