package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseVersion;
import com.alienlab.university.service.CourseVersionService;
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
 * REST controller for managing CourseVersion.
 */
@RestController
@RequestMapping("/api")
public class CourseVersionResource {

    private final Logger log = LoggerFactory.getLogger(CourseVersionResource.class);

    private static final String ENTITY_NAME = "courseVersion";

    private final CourseVersionService courseVersionService;

    public CourseVersionResource(CourseVersionService courseVersionService) {
        this.courseVersionService = courseVersionService;
    }

    /**
     * POST  /course-versions : Create a new courseVersion.
     *
     * @param courseVersion the courseVersion to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseVersion, or with status 400 (Bad Request) if the courseVersion has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-versions")
    @Timed
    public ResponseEntity<CourseVersion> createCourseVersion(@RequestBody CourseVersion courseVersion) throws URISyntaxException {
        log.debug("REST request to save CourseVersion : {}", courseVersion);
        if (courseVersion.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseVersion cannot already have an ID")).body(null);
        }
        CourseVersion result = courseVersionService.save(courseVersion);
        return ResponseEntity.created(new URI("/api/course-versions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-versions : Updates an existing courseVersion.
     *
     * @param courseVersion the courseVersion to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseVersion,
     * or with status 400 (Bad Request) if the courseVersion is not valid,
     * or with status 500 (Internal Server Error) if the courseVersion couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-versions")
    @Timed
    public ResponseEntity<CourseVersion> updateCourseVersion(@RequestBody CourseVersion courseVersion) throws URISyntaxException {
        log.debug("REST request to update CourseVersion : {}", courseVersion);
        if (courseVersion.getId() == null) {
            return createCourseVersion(courseVersion);
        }
        CourseVersion result = courseVersionService.save(courseVersion);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseVersion.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-versions : get all the courseVersions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of courseVersions in body
     */
    @GetMapping("/course-versions")
    @Timed
    public ResponseEntity<List<CourseVersion>> getAllCourseVersions(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of CourseVersions");
        Page<CourseVersion> page = courseVersionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/course-versions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /course-versions/:id : get the "id" courseVersion.
     *
     * @param id the id of the courseVersion to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseVersion, or with status 404 (Not Found)
     */
    @GetMapping("/course-versions/{id}")
    @Timed
    public ResponseEntity<CourseVersion> getCourseVersion(@PathVariable Long id) {
        log.debug("REST request to get CourseVersion : {}", id);
        CourseVersion courseVersion = courseVersionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseVersion));
    }

    /**
     * DELETE  /course-versions/:id : delete the "id" courseVersion.
     *
     * @param id the id of the courseVersion to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-versions/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseVersion(@PathVariable Long id) {
        log.debug("REST request to delete CourseVersion : {}", id);
        courseVersionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
