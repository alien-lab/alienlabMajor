package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseGroupItem;
import com.alienlab.university.service.CourseGroupItemService;
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
 * REST controller for managing CourseGroupItem.
 */
@RestController
@RequestMapping("/api")
public class CourseGroupItemResource {

    private final Logger log = LoggerFactory.getLogger(CourseGroupItemResource.class);

    private static final String ENTITY_NAME = "courseGroupItem";

    private final CourseGroupItemService courseGroupItemService;

    public CourseGroupItemResource(CourseGroupItemService courseGroupItemService) {
        this.courseGroupItemService = courseGroupItemService;
    }

    /**
     * POST  /course-group-items : Create a new courseGroupItem.
     *
     * @param courseGroupItem the courseGroupItem to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseGroupItem, or with status 400 (Bad Request) if the courseGroupItem has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-group-items")
    @Timed
    public ResponseEntity<CourseGroupItem> createCourseGroupItem(@RequestBody CourseGroupItem courseGroupItem) throws URISyntaxException {
        log.debug("REST request to save CourseGroupItem : {}", courseGroupItem);
        if (courseGroupItem.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseGroupItem cannot already have an ID")).body(null);
        }
        CourseGroupItem result = courseGroupItemService.save(courseGroupItem);
        return ResponseEntity.created(new URI("/api/course-group-items/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-group-items : Updates an existing courseGroupItem.
     *
     * @param courseGroupItem the courseGroupItem to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseGroupItem,
     * or with status 400 (Bad Request) if the courseGroupItem is not valid,
     * or with status 500 (Internal Server Error) if the courseGroupItem couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-group-items")
    @Timed
    public ResponseEntity<CourseGroupItem> updateCourseGroupItem(@RequestBody CourseGroupItem courseGroupItem) throws URISyntaxException {
        log.debug("REST request to update CourseGroupItem : {}", courseGroupItem);
        if (courseGroupItem.getId() == null) {
            return createCourseGroupItem(courseGroupItem);
        }
        CourseGroupItem result = courseGroupItemService.save(courseGroupItem);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseGroupItem.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-group-items : get all the courseGroupItems.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of courseGroupItems in body
     */
    @GetMapping("/course-group-items")
    @Timed
    public ResponseEntity<List<CourseGroupItem>> getAllCourseGroupItems(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of CourseGroupItems");
        Page<CourseGroupItem> page = courseGroupItemService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/course-group-items");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /course-group-items/:id : get the "id" courseGroupItem.
     *
     * @param id the id of the courseGroupItem to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseGroupItem, or with status 404 (Not Found)
     */
    @GetMapping("/course-group-items/{id}")
    @Timed
    public ResponseEntity<CourseGroupItem> getCourseGroupItem(@PathVariable Long id) {
        log.debug("REST request to get CourseGroupItem : {}", id);
        CourseGroupItem courseGroupItem = courseGroupItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseGroupItem));
    }

    /**
     * DELETE  /course-group-items/:id : delete the "id" courseGroupItem.
     *
     * @param id the id of the courseGroupItem to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-group-items/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseGroupItem(@PathVariable Long id) {
        log.debug("REST request to delete CourseGroupItem : {}", id);
        courseGroupItemService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
