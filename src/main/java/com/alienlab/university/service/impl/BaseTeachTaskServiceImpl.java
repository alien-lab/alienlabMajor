package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseTeachTaskService;
import com.alienlab.university.domain.BaseTeachTask;
import com.alienlab.university.repository.BaseTeachTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseTeachTask.
 */
@Service
@Transactional
public class BaseTeachTaskServiceImpl implements BaseTeachTaskService{

    private final Logger log = LoggerFactory.getLogger(BaseTeachTaskServiceImpl.class);

    private final BaseTeachTaskRepository baseTeachTaskRepository;

    public BaseTeachTaskServiceImpl(BaseTeachTaskRepository baseTeachTaskRepository) {
        this.baseTeachTaskRepository = baseTeachTaskRepository;
    }

    /**
     * Save a baseTeachTask.
     *
     * @param baseTeachTask the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseTeachTask save(BaseTeachTask baseTeachTask) {
        log.debug("Request to save BaseTeachTask : {}", baseTeachTask);
        return baseTeachTaskRepository.save(baseTeachTask);
    }

    /**
     *  Get all the baseTeachTasks.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseTeachTask> findAll(Pageable pageable) {
        log.debug("Request to get all BaseTeachTasks");
        return baseTeachTaskRepository.findAll(pageable);
    }

    /**
     *  Get one baseTeachTask by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseTeachTask findOne(Long id) {
        log.debug("Request to get BaseTeachTask : {}", id);
        return baseTeachTaskRepository.findOne(id);
    }

    /**
     *  Delete the  baseTeachTask by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseTeachTask : {}", id);
        baseTeachTaskRepository.delete(id);
    }
}
