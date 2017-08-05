package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseTeachTask;
import com.alienlab.university.service.BaseTeachTaskService;
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
 * REST controller for managing BaseTeachTask.
 */
@RestController
@RequestMapping("/api")
public class BaseTeachTaskResource {

    private final Logger log = LoggerFactory.getLogger(BaseTeachTaskResource.class);

    private static final String ENTITY_NAME = "baseTeachTask";

    private final BaseTeachTaskService baseTeachTaskService;

    public BaseTeachTaskResource(BaseTeachTaskService baseTeachTaskService) {
        this.baseTeachTaskService = baseTeachTaskService;
    }

    /**
     * POST  /base-teach-tasks : Create a new baseTeachTask.
     *
     * @param baseTeachTask the baseTeachTask to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseTeachTask, or with status 400 (Bad Request) if the baseTeachTask has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-teach-tasks")
    @Timed
    public ResponseEntity<BaseTeachTask> createBaseTeachTask(@RequestBody BaseTeachTask baseTeachTask) throws URISyntaxException {
        log.debug("REST request to save BaseTeachTask : {}", baseTeachTask);
        if (baseTeachTask.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseTeachTask cannot already have an ID")).body(null);
        }
        BaseTeachTask result = baseTeachTaskService.save(baseTeachTask);
        return ResponseEntity.created(new URI("/api/base-teach-tasks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-teach-tasks : Updates an existing baseTeachTask.
     *
     * @param baseTeachTask the baseTeachTask to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseTeachTask,
     * or with status 400 (Bad Request) if the baseTeachTask is not valid,
     * or with status 500 (Internal Server Error) if the baseTeachTask couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-teach-tasks")
    @Timed
    public ResponseEntity<BaseTeachTask> updateBaseTeachTask(@RequestBody BaseTeachTask baseTeachTask) throws URISyntaxException {
        log.debug("REST request to update BaseTeachTask : {}", baseTeachTask);
        if (baseTeachTask.getId() == null) {
            return createBaseTeachTask(baseTeachTask);
        }
        BaseTeachTask result = baseTeachTaskService.save(baseTeachTask);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseTeachTask.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-teach-tasks : get all the baseTeachTasks.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseTeachTasks in body
     */
    @GetMapping("/base-teach-tasks")
    @Timed
    public ResponseEntity<List<BaseTeachTask>> getAllBaseTeachTasks(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseTeachTasks");
        Page<BaseTeachTask> page = baseTeachTaskService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-teach-tasks");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-teach-tasks/:id : get the "id" baseTeachTask.
     *
     * @param id the id of the baseTeachTask to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseTeachTask, or with status 404 (Not Found)
     */
    @GetMapping("/base-teach-tasks/{id}")
    @Timed
    public ResponseEntity<BaseTeachTask> getBaseTeachTask(@PathVariable Long id) {
        log.debug("REST request to get BaseTeachTask : {}", id);
        BaseTeachTask baseTeachTask = baseTeachTaskService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseTeachTask));
    }

    /**
     * DELETE  /base-teach-tasks/:id : delete the "id" baseTeachTask.
     *
     * @param id the id of the baseTeachTask to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-teach-tasks/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseTeachTask(@PathVariable Long id) {
        log.debug("REST request to delete BaseTeachTask : {}", id);
        baseTeachTaskService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
