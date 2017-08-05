package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.ResourceComment;
import com.alienlab.university.service.ResourceCommentService;
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
 * REST controller for managing ResourceComment.
 */
@RestController
@RequestMapping("/api")
public class ResourceCommentResource {

    private final Logger log = LoggerFactory.getLogger(ResourceCommentResource.class);

    private static final String ENTITY_NAME = "resourceComment";

    private final ResourceCommentService resourceCommentService;

    public ResourceCommentResource(ResourceCommentService resourceCommentService) {
        this.resourceCommentService = resourceCommentService;
    }

    /**
     * POST  /resource-comments : Create a new resourceComment.
     *
     * @param resourceComment the resourceComment to create
     * @return the ResponseEntity with status 201 (Created) and with body the new resourceComment, or with status 400 (Bad Request) if the resourceComment has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/resource-comments")
    @Timed
    public ResponseEntity<ResourceComment> createResourceComment(@RequestBody ResourceComment resourceComment) throws URISyntaxException {
        log.debug("REST request to save ResourceComment : {}", resourceComment);
        if (resourceComment.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new resourceComment cannot already have an ID")).body(null);
        }
        ResourceComment result = resourceCommentService.save(resourceComment);
        return ResponseEntity.created(new URI("/api/resource-comments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /resource-comments : Updates an existing resourceComment.
     *
     * @param resourceComment the resourceComment to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated resourceComment,
     * or with status 400 (Bad Request) if the resourceComment is not valid,
     * or with status 500 (Internal Server Error) if the resourceComment couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/resource-comments")
    @Timed
    public ResponseEntity<ResourceComment> updateResourceComment(@RequestBody ResourceComment resourceComment) throws URISyntaxException {
        log.debug("REST request to update ResourceComment : {}", resourceComment);
        if (resourceComment.getId() == null) {
            return createResourceComment(resourceComment);
        }
        ResourceComment result = resourceCommentService.save(resourceComment);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, resourceComment.getId().toString()))
            .body(result);
    }

    /**
     * GET  /resource-comments : get all the resourceComments.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of resourceComments in body
     */
    @GetMapping("/resource-comments")
    @Timed
    public ResponseEntity<List<ResourceComment>> getAllResourceComments(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of ResourceComments");
        Page<ResourceComment> page = resourceCommentService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/resource-comments");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /resource-comments/:id : get the "id" resourceComment.
     *
     * @param id the id of the resourceComment to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the resourceComment, or with status 404 (Not Found)
     */
    @GetMapping("/resource-comments/{id}")
    @Timed
    public ResponseEntity<ResourceComment> getResourceComment(@PathVariable Long id) {
        log.debug("REST request to get ResourceComment : {}", id);
        ResourceComment resourceComment = resourceCommentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(resourceComment));
    }

    /**
     * DELETE  /resource-comments/:id : delete the "id" resourceComment.
     *
     * @param id the id of the resourceComment to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/resource-comments/{id}")
    @Timed
    public ResponseEntity<Void> deleteResourceComment(@PathVariable Long id) {
        log.debug("REST request to delete ResourceComment : {}", id);
        resourceCommentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
