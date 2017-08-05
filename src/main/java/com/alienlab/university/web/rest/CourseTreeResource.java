package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseTree;
import com.alienlab.university.service.CourseTreeService;
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
 * REST controller for managing CourseTree.
 */
@RestController
@RequestMapping("/api")
public class CourseTreeResource {

    private final Logger log = LoggerFactory.getLogger(CourseTreeResource.class);

    private static final String ENTITY_NAME = "courseTree";

    private final CourseTreeService courseTreeService;

    public CourseTreeResource(CourseTreeService courseTreeService) {
        this.courseTreeService = courseTreeService;
    }

    /**
     * POST  /course-trees : Create a new courseTree.
     *
     * @param courseTree the courseTree to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseTree, or with status 400 (Bad Request) if the courseTree has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-trees")
    @Timed
    public ResponseEntity<CourseTree> createCourseTree(@RequestBody CourseTree courseTree) throws URISyntaxException {
        log.debug("REST request to save CourseTree : {}", courseTree);
        if (courseTree.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseTree cannot already have an ID")).body(null);
        }
        CourseTree result = courseTreeService.save(courseTree);
        return ResponseEntity.created(new URI("/api/course-trees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-trees : Updates an existing courseTree.
     *
     * @param courseTree the courseTree to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseTree,
     * or with status 400 (Bad Request) if the courseTree is not valid,
     * or with status 500 (Internal Server Error) if the courseTree couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-trees")
    @Timed
    public ResponseEntity<CourseTree> updateCourseTree(@RequestBody CourseTree courseTree) throws URISyntaxException {
        log.debug("REST request to update CourseTree : {}", courseTree);
        if (courseTree.getId() == null) {
            return createCourseTree(courseTree);
        }
        CourseTree result = courseTreeService.save(courseTree);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseTree.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-trees : get all the courseTrees.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of courseTrees in body
     */
    @GetMapping("/course-trees")
    @Timed
    public ResponseEntity<List<CourseTree>> getAllCourseTrees(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of CourseTrees");
        Page<CourseTree> page = courseTreeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/course-trees");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /course-trees/:id : get the "id" courseTree.
     *
     * @param id the id of the courseTree to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseTree, or with status 404 (Not Found)
     */
    @GetMapping("/course-trees/{id}")
    @Timed
    public ResponseEntity<CourseTree> getCourseTree(@PathVariable Long id) {
        log.debug("REST request to get CourseTree : {}", id);
        CourseTree courseTree = courseTreeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseTree));
    }

    /**
     * DELETE  /course-trees/:id : delete the "id" courseTree.
     *
     * @param id the id of the courseTree to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-trees/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseTree(@PathVariable Long id) {
        log.debug("REST request to delete CourseTree : {}", id);
        courseTreeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
