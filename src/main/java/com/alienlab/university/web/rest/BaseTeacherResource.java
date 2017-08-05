package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseTeacher;
import com.alienlab.university.service.BaseTeacherService;
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
 * REST controller for managing BaseTeacher.
 */
@RestController
@RequestMapping("/api")
public class BaseTeacherResource {

    private final Logger log = LoggerFactory.getLogger(BaseTeacherResource.class);

    private static final String ENTITY_NAME = "baseTeacher";

    private final BaseTeacherService baseTeacherService;

    public BaseTeacherResource(BaseTeacherService baseTeacherService) {
        this.baseTeacherService = baseTeacherService;
    }

    /**
     * POST  /base-teachers : Create a new baseTeacher.
     *
     * @param baseTeacher the baseTeacher to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseTeacher, or with status 400 (Bad Request) if the baseTeacher has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-teachers")
    @Timed
    public ResponseEntity<BaseTeacher> createBaseTeacher(@RequestBody BaseTeacher baseTeacher) throws URISyntaxException {
        log.debug("REST request to save BaseTeacher : {}", baseTeacher);
        if (baseTeacher.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseTeacher cannot already have an ID")).body(null);
        }
        BaseTeacher result = baseTeacherService.save(baseTeacher);
        return ResponseEntity.created(new URI("/api/base-teachers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-teachers : Updates an existing baseTeacher.
     *
     * @param baseTeacher the baseTeacher to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseTeacher,
     * or with status 400 (Bad Request) if the baseTeacher is not valid,
     * or with status 500 (Internal Server Error) if the baseTeacher couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-teachers")
    @Timed
    public ResponseEntity<BaseTeacher> updateBaseTeacher(@RequestBody BaseTeacher baseTeacher) throws URISyntaxException {
        log.debug("REST request to update BaseTeacher : {}", baseTeacher);
        if (baseTeacher.getId() == null) {
            return createBaseTeacher(baseTeacher);
        }
        BaseTeacher result = baseTeacherService.save(baseTeacher);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseTeacher.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-teachers : get all the baseTeachers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseTeachers in body
     */
    @GetMapping("/base-teachers")
    @Timed
    public ResponseEntity<List<BaseTeacher>> getAllBaseTeachers(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseTeachers");
        Page<BaseTeacher> page = baseTeacherService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-teachers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-teachers/:id : get the "id" baseTeacher.
     *
     * @param id the id of the baseTeacher to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseTeacher, or with status 404 (Not Found)
     */
    @GetMapping("/base-teachers/{id}")
    @Timed
    public ResponseEntity<BaseTeacher> getBaseTeacher(@PathVariable Long id) {
        log.debug("REST request to get BaseTeacher : {}", id);
        BaseTeacher baseTeacher = baseTeacherService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseTeacher));
    }

    /**
     * DELETE  /base-teachers/:id : delete the "id" baseTeacher.
     *
     * @param id the id of the baseTeacher to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-teachers/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseTeacher(@PathVariable Long id) {
        log.debug("REST request to delete BaseTeacher : {}", id);
        baseTeacherService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
