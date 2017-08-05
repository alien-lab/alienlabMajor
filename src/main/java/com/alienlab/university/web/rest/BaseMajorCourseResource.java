package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseMajorCourse;
import com.alienlab.university.service.BaseMajorCourseService;
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
 * REST controller for managing BaseMajorCourse.
 */
@RestController
@RequestMapping("/api")
public class BaseMajorCourseResource {

    private final Logger log = LoggerFactory.getLogger(BaseMajorCourseResource.class);

    private static final String ENTITY_NAME = "baseMajorCourse";

    private final BaseMajorCourseService baseMajorCourseService;

    public BaseMajorCourseResource(BaseMajorCourseService baseMajorCourseService) {
        this.baseMajorCourseService = baseMajorCourseService;
    }

    /**
     * POST  /base-major-courses : Create a new baseMajorCourse.
     *
     * @param baseMajorCourse the baseMajorCourse to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseMajorCourse, or with status 400 (Bad Request) if the baseMajorCourse has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-major-courses")
    @Timed
    public ResponseEntity<BaseMajorCourse> createBaseMajorCourse(@RequestBody BaseMajorCourse baseMajorCourse) throws URISyntaxException {
        log.debug("REST request to save BaseMajorCourse : {}", baseMajorCourse);
        if (baseMajorCourse.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseMajorCourse cannot already have an ID")).body(null);
        }
        BaseMajorCourse result = baseMajorCourseService.save(baseMajorCourse);
        return ResponseEntity.created(new URI("/api/base-major-courses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-major-courses : Updates an existing baseMajorCourse.
     *
     * @param baseMajorCourse the baseMajorCourse to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseMajorCourse,
     * or with status 400 (Bad Request) if the baseMajorCourse is not valid,
     * or with status 500 (Internal Server Error) if the baseMajorCourse couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-major-courses")
    @Timed
    public ResponseEntity<BaseMajorCourse> updateBaseMajorCourse(@RequestBody BaseMajorCourse baseMajorCourse) throws URISyntaxException {
        log.debug("REST request to update BaseMajorCourse : {}", baseMajorCourse);
        if (baseMajorCourse.getId() == null) {
            return createBaseMajorCourse(baseMajorCourse);
        }
        BaseMajorCourse result = baseMajorCourseService.save(baseMajorCourse);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseMajorCourse.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-major-courses : get all the baseMajorCourses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseMajorCourses in body
     */
    @GetMapping("/base-major-courses")
    @Timed
    public ResponseEntity<List<BaseMajorCourse>> getAllBaseMajorCourses(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseMajorCourses");
        Page<BaseMajorCourse> page = baseMajorCourseService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-major-courses");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-major-courses/:id : get the "id" baseMajorCourse.
     *
     * @param id the id of the baseMajorCourse to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseMajorCourse, or with status 404 (Not Found)
     */
    @GetMapping("/base-major-courses/{id}")
    @Timed
    public ResponseEntity<BaseMajorCourse> getBaseMajorCourse(@PathVariable Long id) {
        log.debug("REST request to get BaseMajorCourse : {}", id);
        BaseMajorCourse baseMajorCourse = baseMajorCourseService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseMajorCourse));
    }

    /**
     * DELETE  /base-major-courses/:id : delete the "id" baseMajorCourse.
     *
     * @param id the id of the baseMajorCourse to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-major-courses/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseMajorCourse(@PathVariable Long id) {
        log.debug("REST request to delete BaseMajorCourse : {}", id);
        baseMajorCourseService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
