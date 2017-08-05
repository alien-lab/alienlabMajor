package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseStruct;
import com.alienlab.university.service.CourseStructService;
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
 * REST controller for managing CourseStruct.
 */
@RestController
@RequestMapping("/api")
public class CourseStructResource {

    private final Logger log = LoggerFactory.getLogger(CourseStructResource.class);

    private static final String ENTITY_NAME = "courseStruct";

    private final CourseStructService courseStructService;

    public CourseStructResource(CourseStructService courseStructService) {
        this.courseStructService = courseStructService;
    }

    /**
     * POST  /course-structs : Create a new courseStruct.
     *
     * @param courseStruct the courseStruct to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseStruct, or with status 400 (Bad Request) if the courseStruct has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-structs")
    @Timed
    public ResponseEntity<CourseStruct> createCourseStruct(@RequestBody CourseStruct courseStruct) throws URISyntaxException {
        log.debug("REST request to save CourseStruct : {}", courseStruct);
        if (courseStruct.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseStruct cannot already have an ID")).body(null);
        }
        CourseStruct result = courseStructService.save(courseStruct);
        return ResponseEntity.created(new URI("/api/course-structs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-structs : Updates an existing courseStruct.
     *
     * @param courseStruct the courseStruct to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseStruct,
     * or with status 400 (Bad Request) if the courseStruct is not valid,
     * or with status 500 (Internal Server Error) if the courseStruct couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-structs")
    @Timed
    public ResponseEntity<CourseStruct> updateCourseStruct(@RequestBody CourseStruct courseStruct) throws URISyntaxException {
        log.debug("REST request to update CourseStruct : {}", courseStruct);
        if (courseStruct.getId() == null) {
            return createCourseStruct(courseStruct);
        }
        CourseStruct result = courseStructService.save(courseStruct);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseStruct.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-structs : get all the courseStructs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of courseStructs in body
     */
    @GetMapping("/course-structs")
    @Timed
    public ResponseEntity<List<CourseStruct>> getAllCourseStructs(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of CourseStructs");
        Page<CourseStruct> page = courseStructService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/course-structs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /course-structs/:id : get the "id" courseStruct.
     *
     * @param id the id of the courseStruct to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseStruct, or with status 404 (Not Found)
     */
    @GetMapping("/course-structs/{id}")
    @Timed
    public ResponseEntity<CourseStruct> getCourseStruct(@PathVariable Long id) {
        log.debug("REST request to get CourseStruct : {}", id);
        CourseStruct courseStruct = courseStructService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseStruct));
    }

    /**
     * DELETE  /course-structs/:id : delete the "id" courseStruct.
     *
     * @param id the id of the courseStruct to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-structs/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseStruct(@PathVariable Long id) {
        log.debug("REST request to delete CourseStruct : {}", id);
        courseStructService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
