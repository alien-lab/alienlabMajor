package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.TraningStruct;
import com.alienlab.university.service.TraningStructService;
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
 * REST controller for managing TraningStruct.
 */
@RestController
@RequestMapping("/api")
public class TraningStructResource {

    private final Logger log = LoggerFactory.getLogger(TraningStructResource.class);

    private static final String ENTITY_NAME = "traningStruct";

    private final TraningStructService traningStructService;

    public TraningStructResource(TraningStructService traningStructService) {
        this.traningStructService = traningStructService;
    }

    /**
     * POST  /traning-structs : Create a new traningStruct.
     *
     * @param traningStruct the traningStruct to create
     * @return the ResponseEntity with status 201 (Created) and with body the new traningStruct, or with status 400 (Bad Request) if the traningStruct has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/traning-structs")
    @Timed
    public ResponseEntity<TraningStruct> createTraningStruct(@RequestBody TraningStruct traningStruct) throws URISyntaxException {
        log.debug("REST request to save TraningStruct : {}", traningStruct);
        if (traningStruct.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new traningStruct cannot already have an ID")).body(null);
        }
        TraningStruct result = traningStructService.save(traningStruct);
        return ResponseEntity.created(new URI("/api/traning-structs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /traning-structs : Updates an existing traningStruct.
     *
     * @param traningStruct the traningStruct to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated traningStruct,
     * or with status 400 (Bad Request) if the traningStruct is not valid,
     * or with status 500 (Internal Server Error) if the traningStruct couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/traning-structs")
    @Timed
    public ResponseEntity<TraningStruct> updateTraningStruct(@RequestBody TraningStruct traningStruct) throws URISyntaxException {
        log.debug("REST request to update TraningStruct : {}", traningStruct);
        if (traningStruct.getId() == null) {
            return createTraningStruct(traningStruct);
        }
        TraningStruct result = traningStructService.save(traningStruct);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, traningStruct.getId().toString()))
            .body(result);
    }

    /**
     * GET  /traning-structs : get all the traningStructs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of traningStructs in body
     */
    @GetMapping("/traning-structs")
    @Timed
    public ResponseEntity<List<TraningStruct>> getAllTraningStructs(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of TraningStructs");
        Page<TraningStruct> page = traningStructService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/traning-structs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /traning-structs/:id : get the "id" traningStruct.
     *
     * @param id the id of the traningStruct to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the traningStruct, or with status 404 (Not Found)
     */
    @GetMapping("/traning-structs/{id}")
    @Timed
    public ResponseEntity<TraningStruct> getTraningStruct(@PathVariable Long id) {
        log.debug("REST request to get TraningStruct : {}", id);
        TraningStruct traningStruct = traningStructService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(traningStruct));
    }

    /**
     * DELETE  /traning-structs/:id : delete the "id" traningStruct.
     *
     * @param id the id of the traningStruct to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/traning-structs/{id}")
    @Timed
    public ResponseEntity<Void> deleteTraningStruct(@PathVariable Long id) {
        log.debug("REST request to delete TraningStruct : {}", id);
        traningStructService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
