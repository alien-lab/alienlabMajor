package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseTerm;
import com.alienlab.university.service.BaseTermService;
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
 * REST controller for managing BaseTerm.
 */
@RestController
@RequestMapping("/api")
public class BaseTermResource {

    private final Logger log = LoggerFactory.getLogger(BaseTermResource.class);

    private static final String ENTITY_NAME = "baseTerm";

    private final BaseTermService baseTermService;

    public BaseTermResource(BaseTermService baseTermService) {
        this.baseTermService = baseTermService;
    }

    /**
     * POST  /base-terms : Create a new baseTerm.
     *
     * @param baseTerm the baseTerm to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseTerm, or with status 400 (Bad Request) if the baseTerm has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-terms")
    @Timed
    public ResponseEntity<BaseTerm> createBaseTerm(@RequestBody BaseTerm baseTerm) throws URISyntaxException {
        log.debug("REST request to save BaseTerm : {}", baseTerm);
        if (baseTerm.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseTerm cannot already have an ID")).body(null);
        }
        BaseTerm result = baseTermService.save(baseTerm);
        return ResponseEntity.created(new URI("/api/base-terms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-terms : Updates an existing baseTerm.
     *
     * @param baseTerm the baseTerm to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseTerm,
     * or with status 400 (Bad Request) if the baseTerm is not valid,
     * or with status 500 (Internal Server Error) if the baseTerm couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-terms")
    @Timed
    public ResponseEntity<BaseTerm> updateBaseTerm(@RequestBody BaseTerm baseTerm) throws URISyntaxException {
        log.debug("REST request to update BaseTerm : {}", baseTerm);
        if (baseTerm.getId() == null) {
            return createBaseTerm(baseTerm);
        }
        BaseTerm result = baseTermService.save(baseTerm);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseTerm.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-terms : get all the baseTerms.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseTerms in body
     */
    @GetMapping("/base-terms")
    @Timed
    public ResponseEntity<List<BaseTerm>> getAllBaseTerms(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseTerms");
        Page<BaseTerm> page = baseTermService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-terms");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-terms/:id : get the "id" baseTerm.
     *
     * @param id the id of the baseTerm to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseTerm, or with status 404 (Not Found)
     */
    @GetMapping("/base-terms/{id}")
    @Timed
    public ResponseEntity<BaseTerm> getBaseTerm(@PathVariable Long id) {
        log.debug("REST request to get BaseTerm : {}", id);
        BaseTerm baseTerm = baseTermService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseTerm));
    }

    /**
     * DELETE  /base-terms/:id : delete the "id" baseTerm.
     *
     * @param id the id of the baseTerm to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-terms/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseTerm(@PathVariable Long id) {
        log.debug("REST request to delete BaseTerm : {}", id);
        baseTermService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
