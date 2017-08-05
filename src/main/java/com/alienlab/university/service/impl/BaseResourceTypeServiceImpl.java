package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseResourceTypeService;
import com.alienlab.university.domain.BaseResourceType;
import com.alienlab.university.repository.BaseResourceTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseResourceType.
 */
@Service
@Transactional
public class BaseResourceTypeServiceImpl implements BaseResourceTypeService{

    private final Logger log = LoggerFactory.getLogger(BaseResourceTypeServiceImpl.class);

    private final BaseResourceTypeRepository baseResourceTypeRepository;

    public BaseResourceTypeServiceImpl(BaseResourceTypeRepository baseResourceTypeRepository) {
        this.baseResourceTypeRepository = baseResourceTypeRepository;
    }

    /**
     * Save a baseResourceType.
     *
     * @param baseResourceType the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseResourceType save(BaseResourceType baseResourceType) {
        log.debug("Request to save BaseResourceType : {}", baseResourceType);
        return baseResourceTypeRepository.save(baseResourceType);
    }

    /**
     *  Get all the baseResourceTypes.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseResourceType> findAll(Pageable pageable) {
        log.debug("Request to get all BaseResourceTypes");
        return baseResourceTypeRepository.findAll(pageable);
    }

    /**
     *  Get one baseResourceType by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseResourceType findOne(Long id) {
        log.debug("Request to get BaseResourceType : {}", id);
        return baseResourceTypeRepository.findOne(id);
    }

    /**
     *  Delete the  baseResourceType by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseResourceType : {}", id);
        baseResourceTypeRepository.delete(id);
    }
}
