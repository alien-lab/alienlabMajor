package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseResource;
import com.alienlab.university.service.CourseResourceService;
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
 * REST controller for managing CourseResource.
 */
@RestController
@RequestMapping("/api")
public class CourseResourceResource {

    private final Logger log = LoggerFactory.getLogger(CourseResourceResource.class);

    private static final String ENTITY_NAME = "courseResource";

    private final CourseResourceService courseResourceService;

    public CourseResourceResource(CourseResourceService courseResourceService) {
        this.courseResourceService = courseResourceService;
    }

    /**
     * POST  /course-resources : Create a new courseResource.
     *
     * @param courseResource the courseResource to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseResource, or with status 400 (Bad Request) if the courseResource has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-resources")
    @Timed
    public ResponseEntity<CourseResource> createCourseResource(@RequestBody CourseResource courseResource) throws URISyntaxException {
        log.debug("REST request to save CourseResource : {}", courseResource);
        if (courseResource.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseResource cannot already have an ID")).body(null);
        }
        CourseResource result = courseResourceService.save(courseResource);
        return ResponseEntity.created(new URI("/api/course-resources/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-resources : Updates an existing courseResource.
     *
     * @param courseResource the courseResource to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseResource,
     * or with status 400 (Bad Request) if the courseResource is not valid,
     * or with status 500 (Internal Server Error) if the courseResource couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-resources")
    @Timed
    public ResponseEntity<CourseResource> updateCourseResource(@RequestBody CourseResource courseResource) throws URISyntaxException {
        log.debug("REST request to update CourseResource : {}", courseResource);
        if (courseResource.getId() == null) {
            return createCourseResource(courseResource);
        }
        CourseResource result = courseResourceService.save(courseResource);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseResource.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-resources : get all the courseResources.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of courseResources in body
     */
    @GetMapping("/course-resources")
    @Timed
    public ResponseEntity<List<CourseResource>> getAllCourseResources(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of CourseResources");
        Page<CourseResource> page = courseResourceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/course-resources");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /course-resources/:id : get the "id" courseResource.
     *
     * @param id the id of the courseResource to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseResource, or with status 404 (Not Found)
     */
    @GetMapping("/course-resources/{id}")
    @Timed
    public ResponseEntity<CourseResource> getCourseResource(@PathVariable Long id) {
        log.debug("REST request to get CourseResource : {}", id);
        CourseResource courseResource = courseResourceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseResource));
    }

    /**
     * DELETE  /course-resources/:id : delete the "id" courseResource.
     *
     * @param id the id of the courseResource to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-resources/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseResource(@PathVariable Long id) {
        log.debug("REST request to delete CourseResource : {}", id);
        courseResourceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
