package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseDepartmentService;
import com.alienlab.university.domain.BaseDepartment;
import com.alienlab.university.repository.BaseDepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseDepartment.
 */
@Service
@Transactional
public class BaseDepartmentServiceImpl implements BaseDepartmentService{

    private final Logger log = LoggerFactory.getLogger(BaseDepartmentServiceImpl.class);

    private final BaseDepartmentRepository baseDepartmentRepository;

    public BaseDepartmentServiceImpl(BaseDepartmentRepository baseDepartmentRepository) {
        this.baseDepartmentRepository = baseDepartmentRepository;
    }

    /**
     * Save a baseDepartment.
     *
     * @param baseDepartment the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseDepartment save(BaseDepartment baseDepartment) {
        log.debug("Request to save BaseDepartment : {}", baseDepartment);
        return baseDepartmentRepository.save(baseDepartment);
    }

    /**
     *  Get all the baseDepartments.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseDepartment> findAll(Pageable pageable) {
        log.debug("Request to get all BaseDepartments");
        return baseDepartmentRepository.findAll(pageable);
    }

    /**
     *  Get one baseDepartment by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseDepartment findOne(Long id) {
        log.debug("Request to get BaseDepartment : {}", id);
        return baseDepartmentRepository.findOne(id);
    }

    /**
     *  Delete the  baseDepartment by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseDepartment : {}", id);
        baseDepartmentRepository.delete(id);
    }
}
