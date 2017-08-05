package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseOnClass;
import com.alienlab.university.service.CourseOnClassService;
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
 * REST controller for managing CourseOnClass.
 */
@RestController
@RequestMapping("/api")
public class CourseOnClassResource {

    private final Logger log = LoggerFactory.getLogger(CourseOnClassResource.class);

    private static final String ENTITY_NAME = "courseOnClass";

    private final CourseOnClassService courseOnClassService;

    public CourseOnClassResource(CourseOnClassService courseOnClassService) {
        this.courseOnClassService = courseOnClassService;
    }

    /**
     * POST  /course-on-classes : Create a new courseOnClass.
     *
     * @param courseOnClass the courseOnClass to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseOnClass, or with status 400 (Bad Request) if the courseOnClass has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-on-classes")
    @Timed
    public ResponseEntity<CourseOnClass> createCourseOnClass(@RequestBody CourseOnClass courseOnClass) throws URISyntaxException {
        log.debug("REST request to save CourseOnClass : {}", courseOnClass);
        if (courseOnClass.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseOnClass cannot already have an ID")).body(null);
        }
        CourseOnClass result = courseOnClassService.save(courseOnClass);
        return ResponseEntity.created(new URI("/api/course-on-classes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-on-classes : Updates an existing courseOnClass.
     *
     * @param courseOnClass the courseOnClass to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseOnClass,
     * or with status 400 (Bad Request) if the courseOnClass is not valid,
     * or with status 500 (Internal Server Error) if the courseOnClass couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-on-classes")
    @Timed
    public ResponseEntity<CourseOnClass> updateCourseOnClass(@RequestBody CourseOnClass courseOnClass) throws URISyntaxException {
        log.debug("REST request to update CourseOnClass : {}", courseOnClass);
        if (courseOnClass.getId() == null) {
            return createCourseOnClass(courseOnClass);
        }
        CourseOnClass result = courseOnClassService.save(courseOnClass);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseOnClass.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-on-classes : get all the courseOnClasses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of courseOnClasses in body
     */
    @GetMapping("/course-on-classes")
    @Timed
    public ResponseEntity<List<CourseOnClass>> getAllCourseOnClasses(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of CourseOnClasses");
        Page<CourseOnClass> page = courseOnClassService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/course-on-classes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /course-on-classes/:id : get the "id" courseOnClass.
     *
     * @param id the id of the courseOnClass to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseOnClass, or with status 404 (Not Found)
     */
    @GetMapping("/course-on-classes/{id}")
    @Timed
    public ResponseEntity<CourseOnClass> getCourseOnClass(@PathVariable Long id) {
        log.debug("REST request to get CourseOnClass : {}", id);
        CourseOnClass courseOnClass = courseOnClassService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseOnClass));
    }

    /**
     * DELETE  /course-on-classes/:id : delete the "id" courseOnClass.
     *
     * @param id the id of the courseOnClass to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-on-classes/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseOnClass(@PathVariable Long id) {
        log.debug("REST request to delete CourseOnClass : {}", id);
        courseOnClassService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
