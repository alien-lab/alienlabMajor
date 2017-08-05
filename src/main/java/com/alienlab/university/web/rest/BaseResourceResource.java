package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseResource;
import com.alienlab.university.service.BaseResourceService;
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
 * REST controller for managing BaseResource.
 */
@RestController
@RequestMapping("/api")
public class BaseResourceResource {

    private final Logger log = LoggerFactory.getLogger(BaseResourceResource.class);

    private static final String ENTITY_NAME = "baseResource";

    private final BaseResourceService baseResourceService;

    public BaseResourceResource(BaseResourceService baseResourceService) {
        this.baseResourceService = baseResourceService;
    }

    /**
     * POST  /base-resources : Create a new baseResource.
     *
     * @param baseResource the baseResource to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseResource, or with status 400 (Bad Request) if the baseResource has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-resources")
    @Timed
    public ResponseEntity<BaseResource> createBaseResource(@RequestBody BaseResource baseResource) throws URISyntaxException {
        log.debug("REST request to save BaseResource : {}", baseResource);
        if (baseResource.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseResource cannot already have an ID")).body(null);
        }
        BaseResource result = baseResourceService.save(baseResource);
        return ResponseEntity.created(new URI("/api/base-resources/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-resources : Updates an existing baseResource.
     *
     * @param baseResource the baseResource to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseResource,
     * or with status 400 (Bad Request) if the baseResource is not valid,
     * or with status 500 (Internal Server Error) if the baseResource couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-resources")
    @Timed
    public ResponseEntity<BaseResource> updateBaseResource(@RequestBody BaseResource baseResource) throws URISyntaxException {
        log.debug("REST request to update BaseResource : {}", baseResource);
        if (baseResource.getId() == null) {
            return createBaseResource(baseResource);
        }
        BaseResource result = baseResourceService.save(baseResource);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseResource.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-resources : get all the baseResources.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseResources in body
     */
    @GetMapping("/base-resources")
    @Timed
    public ResponseEntity<List<BaseResource>> getAllBaseResources(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseResources");
        Page<BaseResource> page = baseResourceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-resources");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-resources/:id : get the "id" baseResource.
     *
     * @param id the id of the baseResource to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseResource, or with status 404 (Not Found)
     */
    @GetMapping("/base-resources/{id}")
    @Timed
    public ResponseEntity<BaseResource> getBaseResource(@PathVariable Long id) {
        log.debug("REST request to get BaseResource : {}", id);
        BaseResource baseResource = baseResourceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseResource));
    }

    /**
     * DELETE  /base-resources/:id : delete the "id" baseResource.
     *
     * @param id the id of the baseResource to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-resources/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseResource(@PathVariable Long id) {
        log.debug("REST request to delete BaseResource : {}", id);
        baseResourceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
