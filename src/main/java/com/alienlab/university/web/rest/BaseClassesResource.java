package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseClasses;
import com.alienlab.university.service.BaseClassesService;
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
 * REST controller for managing BaseClasses.
 */
@RestController
@RequestMapping("/api")
public class BaseClassesResource {

    private final Logger log = LoggerFactory.getLogger(BaseClassesResource.class);

    private static final String ENTITY_NAME = "baseClasses";

    private final BaseClassesService baseClassesService;

    public BaseClassesResource(BaseClassesService baseClassesService) {
        this.baseClassesService = baseClassesService;
    }

    /**
     * POST  /base-classes : Create a new baseClasses.
     *
     * @param baseClasses the baseClasses to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseClasses, or with status 400 (Bad Request) if the baseClasses has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-classes")
    @Timed
    public ResponseEntity<BaseClasses> createBaseClasses(@RequestBody BaseClasses baseClasses) throws URISyntaxException {
        log.debug("REST request to save BaseClasses : {}", baseClasses);
        if (baseClasses.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseClasses cannot already have an ID")).body(null);
        }
        BaseClasses result = baseClassesService.save(baseClasses);
        return ResponseEntity.created(new URI("/api/base-classes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-classes : Updates an existing baseClasses.
     *
     * @param baseClasses the baseClasses to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseClasses,
     * or with status 400 (Bad Request) if the baseClasses is not valid,
     * or with status 500 (Internal Server Error) if the baseClasses couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-classes")
    @Timed
    public ResponseEntity<BaseClasses> updateBaseClasses(@RequestBody BaseClasses baseClasses) throws URISyntaxException {
        log.debug("REST request to update BaseClasses : {}", baseClasses);
        if (baseClasses.getId() == null) {
            return createBaseClasses(baseClasses);
        }
        BaseClasses result = baseClassesService.save(baseClasses);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseClasses.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-classes : get all the baseClasses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseClasses in body
     */
    @GetMapping("/base-classes")
    @Timed
    public ResponseEntity<List<BaseClasses>> getAllBaseClasses(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseClasses");
        Page<BaseClasses> page = baseClassesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-classes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-classes/:id : get the "id" baseClasses.
     *
     * @param id the id of the baseClasses to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseClasses, or with status 404 (Not Found)
     */
    @GetMapping("/base-classes/{id}")
    @Timed
    public ResponseEntity<BaseClasses> getBaseClasses(@PathVariable Long id) {
        log.debug("REST request to get BaseClasses : {}", id);
        BaseClasses baseClasses = baseClassesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseClasses));
    }

    /**
     * DELETE  /base-classes/:id : delete the "id" baseClasses.
     *
     * @param id the id of the baseClasses to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-classes/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseClasses(@PathVariable Long id) {
        log.debug("REST request to delete BaseClasses : {}", id);
        baseClassesService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
