package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseGroup;
import com.alienlab.university.service.CourseGroupService;
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
 * REST controller for managing CourseGroup.
 */
@RestController
@RequestMapping("/api")
public class CourseGroupResource {

    private final Logger log = LoggerFactory.getLogger(CourseGroupResource.class);

    private static final String ENTITY_NAME = "courseGroup";

    private final CourseGroupService courseGroupService;

    public CourseGroupResource(CourseGroupService courseGroupService) {
        this.courseGroupService = courseGroupService;
    }

    /**
     * POST  /course-groups : Create a new courseGroup.
     *
     * @param courseGroup the courseGroup to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseGroup, or with status 400 (Bad Request) if the courseGroup has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-groups")
    @Timed
    public ResponseEntity<CourseGroup> createCourseGroup(@RequestBody CourseGroup courseGroup) throws URISyntaxException {
        log.debug("REST request to save CourseGroup : {}", courseGroup);
        if (courseGroup.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseGroup cannot already have an ID")).body(null);
        }
        CourseGroup result = courseGroupService.save(courseGroup);
        return ResponseEntity.created(new URI("/api/course-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-groups : Updates an existing courseGroup.
     *
     * @param courseGroup the courseGroup to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseGroup,
     * or with status 400 (Bad Request) if the courseGroup is not valid,
     * or with status 500 (Internal Server Error) if the courseGroup couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-groups")
    @Timed
    public ResponseEntity<CourseGroup> updateCourseGroup(@RequestBody CourseGroup courseGroup) throws URISyntaxException {
        log.debug("REST request to update CourseGroup : {}", courseGroup);
        if (courseGroup.getId() == null) {
            return createCourseGroup(courseGroup);
        }
        CourseGroup result = courseGroupService.save(courseGroup);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseGroup.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-groups : get all the courseGroups.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of courseGroups in body
     */
    @GetMapping("/course-groups")
    @Timed
    public ResponseEntity<List<CourseGroup>> getAllCourseGroups() {
        log.debug("REST request to get a page of CourseGroups");
        List<CourseGroup> page = courseGroupService.findAll();
        return new ResponseEntity<>(page,  HttpStatus.OK);
    }

    /**
     * GET  /course-groups/:id : get the "id" courseGroup.
     *
     * @param id the id of the courseGroup to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseGroup, or with status 404 (Not Found)
     */
    @GetMapping("/course-groups/{id}")
    @Timed
    public ResponseEntity<CourseGroup> getCourseGroup(@PathVariable Long id) {
        log.debug("REST request to get CourseGroup : {}", id);
        CourseGroup courseGroup = courseGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseGroup));
    }

    /**
     * DELETE  /course-groups/:id : delete the "id" courseGroup.
     *
     * @param id the id of the courseGroup to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-groups/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseGroup(@PathVariable Long id) {
        log.debug("REST request to delete CourseGroup : {}", id);
        courseGroupService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
