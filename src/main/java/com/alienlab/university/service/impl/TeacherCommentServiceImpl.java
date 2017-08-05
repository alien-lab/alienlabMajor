package com.alienlab.university.service.impl;

import com.alienlab.university.service.TeacherCommentService;
import com.alienlab.university.domain.TeacherComment;
import com.alienlab.university.repository.TeacherCommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing TeacherComment.
 */
@Service
@Transactional
public class TeacherCommentServiceImpl implements TeacherCommentService{

    private final Logger log = LoggerFactory.getLogger(TeacherCommentServiceImpl.class);

    private final TeacherCommentRepository teacherCommentRepository;

    public TeacherCommentServiceImpl(TeacherCommentRepository teacherCommentRepository) {
        this.teacherCommentRepository = teacherCommentRepository;
    }

    /**
     * Save a teacherComment.
     *
     * @param teacherComment the entity to save
     * @return the persisted entity
     */
    @Override
    public TeacherComment save(TeacherComment teacherComment) {
        log.debug("Request to save TeacherComment : {}", teacherComment);
        return teacherCommentRepository.save(teacherComment);
    }

    /**
     *  Get all the teacherComments.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TeacherComment> findAll(Pageable pageable) {
        log.debug("Request to get all TeacherComments");
        return teacherCommentRepository.findAll(pageable);
    }

    /**
     *  Get one teacherComment by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TeacherComment findOne(Long id) {
        log.debug("Request to get TeacherComment : {}", id);
        return teacherCommentRepository.findOne(id);
    }

    /**
     *  Delete the  teacherComment by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TeacherComment : {}", id);
        teacherCommentRepository.delete(id);
    }
}
