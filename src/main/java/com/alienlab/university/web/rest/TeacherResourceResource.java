package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.TeacherResource;
import com.alienlab.university.service.TeacherResourceService;
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
 * REST controller for managing TeacherResource.
 */
@RestController
@RequestMapping("/api")
public class TeacherResourceResource {

    private final Logger log = LoggerFactory.getLogger(TeacherResourceResource.class);

    private static final String ENTITY_NAME = "teacherResource";

    private final TeacherResourceService teacherResourceService;

    public TeacherResourceResource(TeacherResourceService teacherResourceService) {
        this.teacherResourceService = teacherResourceService;
    }

    /**
     * POST  /teacher-resources : Create a new teacherResource.
     *
     * @param teacherResource the teacherResource to create
     * @return the ResponseEntity with status 201 (Created) and with body the new teacherResource, or with status 400 (Bad Request) if the teacherResource has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/teacher-resources")
    @Timed
    public ResponseEntity<TeacherResource> createTeacherResource(@RequestBody TeacherResource teacherResource) throws URISyntaxException {
        log.debug("REST request to save TeacherResource : {}", teacherResource);
        if (teacherResource.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new teacherResource cannot already have an ID")).body(null);
        }
        TeacherResource result = teacherResourceService.save(teacherResource);
        return ResponseEntity.created(new URI("/api/teacher-resources/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /teacher-resources : Updates an existing teacherResource.
     *
     * @param teacherResource the teacherResource to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated teacherResource,
     * or with status 400 (Bad Request) if the teacherResource is not valid,
     * or with status 500 (Internal Server Error) if the teacherResource couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/teacher-resources")
    @Timed
    public ResponseEntity<TeacherResource> updateTeacherResource(@RequestBody TeacherResource teacherResource) throws URISyntaxException {
        log.debug("REST request to update TeacherResource : {}", teacherResource);
        if (teacherResource.getId() == null) {
            return createTeacherResource(teacherResource);
        }
        TeacherResource result = teacherResourceService.save(teacherResource);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, teacherResource.getId().toString()))
            .body(result);
    }

    /**
     * GET  /teacher-resources : get all the teacherResources.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of teacherResources in body
     */
    @GetMapping("/teacher-resources")
    @Timed
    public ResponseEntity<List<TeacherResource>> getAllTeacherResources(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of TeacherResources");
        Page<TeacherResource> page = teacherResourceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/teacher-resources");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /teacher-resources/:id : get the "id" teacherResource.
     *
     * @param id the id of the teacherResource to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the teacherResource, or with status 404 (Not Found)
     */
    @GetMapping("/teacher-resources/{id}")
    @Timed
    public ResponseEntity<TeacherResource> getTeacherResource(@PathVariable Long id) {
        log.debug("REST request to get TeacherResource : {}", id);
        TeacherResource teacherResource = teacherResourceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(teacherResource));
    }

    /**
     * DELETE  /teacher-resources/:id : delete the "id" teacherResource.
     *
     * @param id the id of the teacherResource to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/teacher-resources/{id}")
    @Timed
    public ResponseEntity<Void> deleteTeacherResource(@PathVariable Long id) {
        log.debug("REST request to delete TeacherResource : {}", id);
        teacherResourceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
