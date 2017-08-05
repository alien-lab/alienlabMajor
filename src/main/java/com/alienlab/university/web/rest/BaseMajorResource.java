package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseMajor;
import com.alienlab.university.service.BaseMajorService;
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
 * REST controller for managing BaseMajor.
 */
@RestController
@RequestMapping("/api")
public class BaseMajorResource {

    private final Logger log = LoggerFactory.getLogger(BaseMajorResource.class);

    private static final String ENTITY_NAME = "baseMajor";

    private final BaseMajorService baseMajorService;

    public BaseMajorResource(BaseMajorService baseMajorService) {
        this.baseMajorService = baseMajorService;
    }

    /**
     * POST  /base-majors : Create a new baseMajor.
     *
     * @param baseMajor the baseMajor to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseMajor, or with status 400 (Bad Request) if the baseMajor has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-majors")
    @Timed
    public ResponseEntity<BaseMajor> createBaseMajor(@RequestBody BaseMajor baseMajor) throws URISyntaxException {
        log.debug("REST request to save BaseMajor : {}", baseMajor);
        if (baseMajor.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseMajor cannot already have an ID")).body(null);
        }
        BaseMajor result = baseMajorService.save(baseMajor);
        return ResponseEntity.created(new URI("/api/base-majors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-majors : Updates an existing baseMajor.
     *
     * @param baseMajor the baseMajor to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseMajor,
     * or with status 400 (Bad Request) if the baseMajor is not valid,
     * or with status 500 (Internal Server Error) if the baseMajor couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-majors")
    @Timed
    public ResponseEntity<BaseMajor> updateBaseMajor(@RequestBody BaseMajor baseMajor) throws URISyntaxException {
        log.debug("REST request to update BaseMajor : {}", baseMajor);
        if (baseMajor.getId() == null) {
            return createBaseMajor(baseMajor);
        }
        BaseMajor result = baseMajorService.save(baseMajor);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseMajor.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-majors : get all the baseMajors.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseMajors in body
     */
    @GetMapping("/base-majors")
    @Timed
    public ResponseEntity<List<BaseMajor>> getAllBaseMajors(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseMajors");
        Page<BaseMajor> page = baseMajorService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-majors");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-majors/:id : get the "id" baseMajor.
     *
     * @param id the id of the baseMajor to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseMajor, or with status 404 (Not Found)
     */
    @GetMapping("/base-majors/{id}")
    @Timed
    public ResponseEntity<BaseMajor> getBaseMajor(@PathVariable Long id) {
        log.debug("REST request to get BaseMajor : {}", id);
        BaseMajor baseMajor = baseMajorService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseMajor));
    }

    /**
     * DELETE  /base-majors/:id : delete the "id" baseMajor.
     *
     * @param id the id of the baseMajor to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-majors/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseMajor(@PathVariable Long id) {
        log.debug("REST request to delete BaseMajor : {}", id);
        baseMajorService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
