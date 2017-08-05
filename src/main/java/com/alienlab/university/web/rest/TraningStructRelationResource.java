package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.TraningStructRelation;
import com.alienlab.university.service.TraningStructRelationService;
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
 * REST controller for managing TraningStructRelation.
 */
@RestController
@RequestMapping("/api")
public class TraningStructRelationResource {

    private final Logger log = LoggerFactory.getLogger(TraningStructRelationResource.class);

    private static final String ENTITY_NAME = "traningStructRelation";

    private final TraningStructRelationService traningStructRelationService;

    public TraningStructRelationResource(TraningStructRelationService traningStructRelationService) {
        this.traningStructRelationService = traningStructRelationService;
    }

    /**
     * POST  /traning-struct-relations : Create a new traningStructRelation.
     *
     * @param traningStructRelation the traningStructRelation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new traningStructRelation, or with status 400 (Bad Request) if the traningStructRelation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/traning-struct-relations")
    @Timed
    public ResponseEntity<TraningStructRelation> createTraningStructRelation(@RequestBody TraningStructRelation traningStructRelation) throws URISyntaxException {
        log.debug("REST request to save TraningStructRelation : {}", traningStructRelation);
        if (traningStructRelation.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new traningStructRelation cannot already have an ID")).body(null);
        }
        TraningStructRelation result = traningStructRelationService.save(traningStructRelation);
        return ResponseEntity.created(new URI("/api/traning-struct-relations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /traning-struct-relations : Updates an existing traningStructRelation.
     *
     * @param traningStructRelation the traningStructRelation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated traningStructRelation,
     * or with status 400 (Bad Request) if the traningStructRelation is not valid,
     * or with status 500 (Internal Server Error) if the traningStructRelation couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/traning-struct-relations")
    @Timed
    public ResponseEntity<TraningStructRelation> updateTraningStructRelation(@RequestBody TraningStructRelation traningStructRelation) throws URISyntaxException {
        log.debug("REST request to update TraningStructRelation : {}", traningStructRelation);
        if (traningStructRelation.getId() == null) {
            return createTraningStructRelation(traningStructRelation);
        }
        TraningStructRelation result = traningStructRelationService.save(traningStructRelation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, traningStructRelation.getId().toString()))
            .body(result);
    }

    /**
     * GET  /traning-struct-relations : get all the traningStructRelations.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of traningStructRelations in body
     */
    @GetMapping("/traning-struct-relations")
    @Timed
    public ResponseEntity<List<TraningStructRelation>> getAllTraningStructRelations(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of TraningStructRelations");
        Page<TraningStructRelation> page = traningStructRelationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/traning-struct-relations");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /traning-struct-relations/:id : get the "id" traningStructRelation.
     *
     * @param id the id of the traningStructRelation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the traningStructRelation, or with status 404 (Not Found)
     */
    @GetMapping("/traning-struct-relations/{id}")
    @Timed
    public ResponseEntity<TraningStructRelation> getTraningStructRelation(@PathVariable Long id) {
        log.debug("REST request to get TraningStructRelation : {}", id);
        TraningStructRelation traningStructRelation = traningStructRelationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(traningStructRelation));
    }

    /**
     * DELETE  /traning-struct-relations/:id : delete the "id" traningStructRelation.
     *
     * @param id the id of the traningStructRelation to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/traning-struct-relations/{id}")
    @Timed
    public ResponseEntity<Void> deleteTraningStructRelation(@PathVariable Long id) {
        log.debug("REST request to delete TraningStructRelation : {}", id);
        traningStructRelationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
