package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.TeacherComment;
import com.alienlab.university.service.TeacherCommentService;
import com.alienlab.university.web.rest.util.HeaderUtil;
import com.alienlab.university.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing TeacherComment.
 */
@RestController
@RequestMapping("/api")
public class TeacherCommentResource {

    private final Logger log = LoggerFactory.getLogger(TeacherCommentResource.class);

    private static final String ENTITY_NAME = "teacherComment";

    private final TeacherCommentService teacherCommentService;

    public TeacherCommentResource(TeacherCommentService teacherCommentService) {
        this.teacherCommentService = teacherCommentService;
    }

    /**
     * POST  /teacher-comments : Create a new teacherComment.
     *
     * @param teacherComment the teacherComment to create
     * @return the ResponseEntity with status 201 (Created) and with body the new teacherComment, or with status 400 (Bad Request) if the teacherComment has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/teacher-comments")
    @Timed
    public ResponseEntity<TeacherComment> createTeacherComment(@RequestBody TeacherComment teacherComment) throws URISyntaxException {
        log.debug("REST request to save TeacherComment : {}", teacherComment);
        if (teacherComment.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new teacherComment cannot already have an ID")).body(null);
        }
        TeacherComment result = teacherCommentService.save(teacherComment);
        return ResponseEntity.created(new URI("/api/teacher-comments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /teacher-comments : Updates an existing teacherComment.
     *
     * @param teacherComment the teacherComment to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated teacherComment,
     * or with status 400 (Bad Request) if the teacherComment is not valid,
     * or with status 500 (Internal Server Error) if the teacherComment couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/teacher-comments")
    @Timed
    public ResponseEntity<TeacherComment> updateTeacherComment(@RequestBody TeacherComment teacherComment) throws URISyntaxException {
        log.debug("REST request to update TeacherComment : {}", teacherComment);
        if (teacherComment.getId() == null) {
            return createTeacherComment(teacherComment);
        }
        TeacherComment result = teacherCommentService.save(teacherComment);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, teacherComment.getId().toString()))
            .body(result);
    }

    /**
     * GET  /teacher-comments : get all the teacherComments.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of teacherComments in body
     */
    @GetMapping("/teacher-comments")
    @Timed
    public ResponseEntity<List<TeacherComment>> getAllTeacherComments(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of TeacherComments");
        Page<TeacherComment> page = teacherCommentService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/teacher-comments");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /teacher-comments/:id : get the "id" teacherComment.
     *
     * @param id the id of the teacherComment to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the teacherComment, or with status 404 (Not Found)
     */
    @GetMapping("/teacher-comments/{id}")
    @Timed
    public ResponseEntity<TeacherComment> getTeacherComment(@PathVariable Long id) {
        log.debug("REST request to get TeacherComment : {}", id);
        TeacherComment teacherComment = teacherCommentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(teacherComment));
    }

    /**
     * DELETE  /teacher-comments/:id : delete the "id" teacherComment.
     *
     * @param id the id of the teacherComment to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/teacher-comments/{id}")
    @Timed
    public ResponseEntity<Void> deleteTeacherComment(@PathVariable Long id) {
        log.debug("REST request to delete TeacherComment : {}", id);
        teacherCommentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
