package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.CourseTalk;
import com.alienlab.university.service.CourseTalkService;
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
 * REST controller for managing CourseTalk.
 */
@RestController
@RequestMapping("/api")
public class CourseTalkResource {

    private final Logger log = LoggerFactory.getLogger(CourseTalkResource.class);

    private static final String ENTITY_NAME = "courseTalk";

    private final CourseTalkService courseTalkService;

    public CourseTalkResource(CourseTalkService courseTalkService) {
        this.courseTalkService = courseTalkService;
    }

    /**
     * POST  /course-talks : Create a new courseTalk.
     *
     * @param courseTalk the courseTalk to create
     * @return the ResponseEntity with status 201 (Created) and with body the new courseTalk, or with status 400 (Bad Request) if the courseTalk has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/course-talks")
    @Timed
    public ResponseEntity<CourseTalk> createCourseTalk(@RequestBody CourseTalk courseTalk) throws URISyntaxException {
        log.debug("REST request to save CourseTalk : {}", courseTalk);
        if (courseTalk.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new courseTalk cannot already have an ID")).body(null);
        }
        CourseTalk result = courseTalkService.save(courseTalk);
        return ResponseEntity.created(new URI("/api/course-talks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /course-talks : Updates an existing courseTalk.
     *
     * @param courseTalk the courseTalk to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated courseTalk,
     * or with status 400 (Bad Request) if the courseTalk is not valid,
     * or with status 500 (Internal Server Error) if the courseTalk couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/course-talks")
    @Timed
    public ResponseEntity<CourseTalk> updateCourseTalk(@RequestBody CourseTalk courseTalk) throws URISyntaxException {
        log.debug("REST request to update CourseTalk : {}", courseTalk);
        if (courseTalk.getId() == null) {
            return createCourseTalk(courseTalk);
        }
        CourseTalk result = courseTalkService.save(courseTalk);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, courseTalk.getId().toString()))
            .body(result);
    }

    /**
     * GET  /course-talks : get all the courseTalks.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of courseTalks in body
     */
    @GetMapping("/course-talks")
    @Timed
    public ResponseEntity<List<CourseTalk>> getAllCourseTalks(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of CourseTalks");
        Page<CourseTalk> page = courseTalkService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/course-talks");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /course-talks/:id : get the "id" courseTalk.
     *
     * @param id the id of the courseTalk to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the courseTalk, or with status 404 (Not Found)
     */
    @GetMapping("/course-talks/{id}")
    @Timed
    public ResponseEntity<CourseTalk> getCourseTalk(@PathVariable Long id) {
        log.debug("REST request to get CourseTalk : {}", id);
        CourseTalk courseTalk = courseTalkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(courseTalk));
    }

    /**
     * DELETE  /course-talks/:id : delete the "id" courseTalk.
     *
     * @param id the id of the courseTalk to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/course-talks/{id}")
    @Timed
    public ResponseEntity<Void> deleteCourseTalk(@PathVariable Long id) {
        log.debug("REST request to delete CourseTalk : {}", id);
        courseTalkService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
