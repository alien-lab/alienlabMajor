package com.alienlab.university.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.alienlab.university.domain.BaseDepartment;
import com.alienlab.university.service.BaseDepartmentService;
import com.alienlab.university.web.rest.util.HeaderUtil;
import com.alienlab.university.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 * REST controller for managing BaseDepartment.
 */
@RestController
@RequestMapping("/api")
public class BaseDepartmentResource {

    private final Logger log = LoggerFactory.getLogger(BaseDepartmentResource.class);

    private static final String ENTITY_NAME = "baseDepartment";

    private final BaseDepartmentService baseDepartmentService;

    public BaseDepartmentResource(BaseDepartmentService baseDepartmentService) {
        this.baseDepartmentService = baseDepartmentService;
    }

    /**
     * POST  /base-departments : Create a new baseDepartment.
     *
     * @param baseDepartment the baseDepartment to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseDepartment, or with status 400 (Bad Request) if the baseDepartment has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-departments")
    @Timed
    public ResponseEntity<BaseDepartment> createBaseDepartment(@RequestBody BaseDepartment baseDepartment) throws URISyntaxException {
        log.debug("REST request to save BaseDepartment : {}", baseDepartment);
        if (baseDepartment.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new baseDepartment cannot already have an ID")).body(null);
        }
        BaseDepartment result = baseDepartmentService.save(baseDepartment);
        return ResponseEntity.created(new URI("/api/base-departments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-departments : Updates an existing baseDepartment.
     *
     * @param baseDepartment the baseDepartment to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseDepartment,
     * or with status 400 (Bad Request) if the baseDepartment is not valid,
     * or with status 500 (Internal Server Error) if the baseDepartment couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-departments")
    @Timed
    public ResponseEntity<BaseDepartment> updateBaseDepartment(@RequestBody BaseDepartment baseDepartment) throws URISyntaxException {
        log.debug("REST request to update BaseDepartment : {}", baseDepartment);
        if (baseDepartment.getId() == null) {
            return createBaseDepartment(baseDepartment);
        }
        BaseDepartment result = baseDepartmentService.save(baseDepartment);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseDepartment.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-departments : get all the baseDepartments.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseDepartments in body
     */
    @GetMapping("/base-departments")
    @Timed
    public ResponseEntity<List<BaseDepartment>> getAllBaseDepartments(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of BaseDepartments");
        Page<BaseDepartment> page = baseDepartmentService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-departments");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /base-departments/:id : get the "id" baseDepartment.
     *
     * @param id the id of the baseDepartment to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseDepartment, or with status 404 (Not Found)
     */
    @GetMapping("/base-departments/{id}")
    @Timed
    public ResponseEntity<BaseDepartment> getBaseDepartment(@PathVariable Long id) {
        log.debug("REST request to get BaseDepartment : {}", id);
        BaseDepartment baseDepartment = baseDepartmentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(baseDepartment));
    }

    /**
     * DELETE  /base-departments/:id : delete the "id" baseDepartment.
     *
     * @param id the id of the baseDepartment to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-departments/{id}")
    @Timed
    public ResponseEntity<Void> deleteBaseDepartment(@PathVariable Long id) {
        log.debug("REST request to delete BaseDepartment : {}", id);
        baseDepartmentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

 /*   @PostMapping("")
    @ApiOperation(value="",notes="")
    @ApiImplicitParams({
        @ApiImplicitParam(name="",value="",dataType="")
    })
    public ResponseEntity funName(){
      try {
        return ResponseEntity.ok().body("");
      }catch (Exception e){
        e.printStackTrace();
        ExecResult er=new ExecResult(false,e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
      }
    }*/
}
