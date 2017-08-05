package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseResourceType;
import com.alienlab.university.service.BaseResourceTypeService;
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
 * REST controller for managing BaseResourceType.
 */
@RestController
@RequestMapping("/api")
public class BaseResourceTypeResource {

    private final Logger log = LoggerFactory.getLogger(BaseResourceTypeResource.class);

    private static final String ENTITY_NAME = "baseResourceType";

    private final BaseResourceTypeService baseResourceTypeService;

    public BaseResourceTypeResource(BaseResourceTypeService baseResourceTypeService) {
        this.baseResourceTypeService = baseResourceTypeService;
    }

    /**
     * POST  /base-resource-types : Create a new baseResourceType.
     *
     * @param baseResourceType the baseResourceType to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseResourceType, or with status 400 (Bad Request) if the baseResourceType has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-resource-types")
    @Timed
    public ResponseEntity<BaseResourceType> createBaseResourceType(@RequestBody BaseResourceType baseResourceType) throws URISyntaxException {
        log.debug("REST request to save BaseResourceType : {}", baseResourceType);
        if (baseResourceType.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseResourceType cannot already have an ID")).body(null);
        }
        BaseResourceType result = baseResourceTypeService.save(baseResourceType);
        return ResponseEntity.created(new URI("/api/base-resource-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-resource-types : Updates an existing baseResourceType.
     *
     * @param baseResourceType the baseResourceType to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseResourceType,
     * or with status 400 (Bad Request) if the baseResourceType is not valid,
     * or with status 500 (Internal Server Error) if the baseResourceType couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-resource-types")
    @Timed
    public ResponseEntity<BaseResourceType> updateBaseResourceType(@RequestBody BaseResourceType baseResourceType) throws URISyntaxException {
        log.debug("REST request to update BaseResourceType : {}", baseResourceType);
        if (baseResourceType.getId() == null) {
            return createBaseResourceType(baseResourceType);
        }
        BaseResourceType result = baseResourceTypeService.save(baseResourceType);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseResourceType.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-resource-types : get all the baseResourceTypes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseResourceTypes in body
     */
    @GetMapping("/base-resource-types")
    @Timed
    public ResponseEntity<List<BaseResourceType>> getAllBaseResourceTypes(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseResourceTypes");
        Page<BaseResourceType> page = baseResourceTypeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-resource-types");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-resource-types/:id : get the "id" baseResourceType.
     *
     * @param id the id of the baseResourceType to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseResourceType, or with status 404 (Not Found)
     */
    @GetMapping("/base-resource-types/{id}")
    @Timed
    public ResponseEntity<BaseResourceType> getBaseResourceType(@PathVariable Long id) {
        log.debug("REST request to get BaseResourceType : {}", id);
        BaseResourceType baseResourceType = baseResourceTypeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseResourceType));
    }

    /**
     * DELETE  /base-resource-types/:id : delete the "id" baseResourceType.
     *
     * @param id the id of the baseResourceType to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-resource-types/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseResourceType(@PathVariable Long id) {
        log.debug("REST request to delete BaseResourceType : {}", id);
        baseResourceTypeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
