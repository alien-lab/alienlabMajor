package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseCourse;
import com.alienlab.university.service.BaseCourseService;
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
 * REST controller for managing BaseCourse.
 */
@RestController
@RequestMapping("/api")
public class BaseCourseResource {

    private final Logger log = LoggerFactory.getLogger(BaseCourseResource.class);

    private static final String ENTITY_NAME = "baseCourse";

    private final BaseCourseService baseCourseService;

    public BaseCourseResource(BaseCourseService baseCourseService) {
        this.baseCourseService = baseCourseService;
    }

    /**
     * POST  /base-courses : Create a new baseCourse.
     *
     * @param baseCourse the baseCourse to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseCourse, or with status 400 (Bad Request) if the baseCourse has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-courses")
    @Timed
    public ResponseEntity<BaseCourse> createBaseCourse(@RequestBody BaseCourse baseCourse) throws URISyntaxException {
        log.debug("REST request to save BaseCourse : {}", baseCourse);
        if (baseCourse.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseCourse cannot already have an ID")).body(null);
        }
        BaseCourse result = baseCourseService.save(baseCourse);
        return ResponseEntity.created(new URI("/api/base-courses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-courses : Updates an existing baseCourse.
     *
     * @param baseCourse the baseCourse to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseCourse,
     * or with status 400 (Bad Request) if the baseCourse is not valid,
     * or with status 500 (Internal Server Error) if the baseCourse couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-courses")
    @Timed
    public ResponseEntity<BaseCourse> updateBaseCourse(@RequestBody BaseCourse baseCourse) throws URISyntaxException {
        log.debug("REST request to update BaseCourse : {}", baseCourse);
        if (baseCourse.getId() == null) {
            return createBaseCourse(baseCourse);
        }
        BaseCourse result = baseCourseService.save(baseCourse);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseCourse.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-courses : get all the baseCourses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseCourses in body
     */
    @GetMapping("/base-courses")
    @Timed
    public ResponseEntity<List<BaseCourse>> getAllBaseCourses(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseCourses");
        Page<BaseCourse> page = baseCourseService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-courses");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-courses/:id : get the "id" baseCourse.
     *
     * @param id the id of the baseCourse to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseCourse, or with status 404 (Not Found)
     */
    @GetMapping("/base-courses/{id}")
    @Timed
    public ResponseEntity<BaseCourse> getBaseCourse(@PathVariable Long id) {
        log.debug("REST request to get BaseCourse : {}", id);
        BaseCourse baseCourse = baseCourseService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseCourse));
    }

    /**
     * DELETE  /base-courses/:id : delete the "id" baseCourse.
     *
     * @param id the id of the baseCourse to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-courses/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseCourse(@PathVariable Long id) {
        log.debug("REST request to delete BaseCourse : {}", id);
        baseCourseService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
