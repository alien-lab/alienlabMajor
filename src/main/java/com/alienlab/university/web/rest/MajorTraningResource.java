package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.MajorTraning;
import com.alienlab.university.service.MajorTraningService;
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
 * REST controller for managing MajorTraning.
 */
@RestController
@RequestMapping("/api")
public class MajorTraningResource {

    private final Logger log = LoggerFactory.getLogger(MajorTraningResource.class);

    private static final String ENTITY_NAME = "majorTraning";

    private final MajorTraningService majorTraningService;

    public MajorTraningResource(MajorTraningService majorTraningService) {
        this.majorTraningService = majorTraningService;
    }

    /**
     * POST  /major-tranings : Create a new majorTraning.
     *
     * @param majorTraning the majorTraning to create
     * @return the ResponseEntity with status 201 (Created) and with body the new majorTraning, or with status 400 (Bad Request) if the majorTraning has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/major-tranings")
    @Timed
    public ResponseEntity<MajorTraning> createMajorTraning(@RequestBody MajorTraning majorTraning) throws URISyntaxException {
        log.debug("REST request to save MajorTraning : {}", majorTraning);
        if (majorTraning.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new majorTraning cannot already have an ID")).body(null);
        }
        MajorTraning result = majorTraningService.save(majorTraning);
        return ResponseEntity.created(new URI("/api/major-tranings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /major-tranings : Updates an existing majorTraning.
     *
     * @param majorTraning the majorTraning to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated majorTraning,
     * or with status 400 (Bad Request) if the majorTraning is not valid,
     * or with status 500 (Internal Server Error) if the majorTraning couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/major-tranings")
    @Timed
    public ResponseEntity<MajorTraning> updateMajorTraning(@RequestBody MajorTraning majorTraning) throws URISyntaxException {
        log.debug("REST request to update MajorTraning : {}", majorTraning);
        if (majorTraning.getId() == null) {
            return createMajorTraning(majorTraning);
        }
        MajorTraning result = majorTraningService.save(majorTraning);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, majorTraning.getId().toString()))
            .body(result);
    }

    /**
     * GET  /major-tranings : get all the majorTranings.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of majorTranings in body
     */
    @GetMapping("/major-tranings")
    @Timed
    public ResponseEntity<List<MajorTraning>> getAllMajorTranings(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of MajorTranings");
        Page<MajorTraning> page = majorTraningService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/major-tranings");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /major-tranings/:id : get the "id" majorTraning.
     *
     * @param id the id of the majorTraning to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the majorTraning, or with status 404 (Not Found)
     */
    @GetMapping("/major-tranings/{id}")
    @Timed
    public ResponseEntity<MajorTraning> getMajorTraning(@PathVariable Long id) {
        log.debug("REST request to get MajorTraning : {}", id);
        MajorTraning majorTraning = majorTraningService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(majorTraning));
    }

    /**
     * DELETE  /major-tranings/:id : delete the "id" majorTraning.
     *
     * @param id the id of the majorTraning to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/major-tranings/{id}")
    @Timed
    public ResponseEntity<Void> deleteMajorTraning(@PathVariable Long id) {
        log.debug("REST request to delete MajorTraning : {}", id);
        majorTraningService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
