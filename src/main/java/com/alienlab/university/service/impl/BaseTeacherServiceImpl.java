package com.alienlab.university.service.impl;

import com.alienlab.university.service.BaseTeacherService;
import com.alienlab.university.domain.BaseTeacher;
import com.alienlab.university.repository.BaseTeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BaseTeacher.
 */
@Service
@Transactional
public class BaseTeacherServiceImpl implements BaseTeacherService{

    private final Logger log = LoggerFactory.getLogger(BaseTeacherServiceImpl.class);

    private final BaseTeacherRepository baseTeacherRepository;

    public BaseTeacherServiceImpl(BaseTeacherRepository baseTeacherRepository) {
        this.baseTeacherRepository = baseTeacherRepository;
    }

    /**
     * Save a baseTeacher.
     *
     * @param baseTeacher the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseTeacher save(BaseTeacher baseTeacher) {
        log.debug("Request to save BaseTeacher : {}", baseTeacher);
        return baseTeacherRepository.save(baseTeacher);
    }

    /**
     *  Get all the baseTeachers.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseTeacher> findAll(Pageable pageable) {
        log.debug("Request to get all BaseTeachers");
        return baseTeacherRepository.findAll(pageable);
    }

    /**
     *  Get one baseTeacher by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BaseTeacher findOne(Long id) {
        log.debug("Request to get BaseTeacher : {}", id);
        return baseTeacherRepository.findOne(id);
    }

    /**
     *  Delete the  baseTeacher by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseTeacher : {}", id);
        baseTeacherRepository.delete(id);
    }
}
