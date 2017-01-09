package jp.bikon.web;

import jp.bikon.model.Example;
import jp.bikon.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
@RequestMapping(value = "/example")
@RestController
public class ExampleController {

    private final ExampleService service;

    @Autowired
    public ExampleController(final ExampleService service) {
        this.service = service;
    }

    // CRUD methods ============================================================

    @PostMapping()
    public Example create(@Valid @RequestBody final Example entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Example update(@PathVariable("id") final String id, @Valid @RequestBody final Example entity) {

        // TODO - check entity exists by querying with id.
        return service.update(entity);
    }

    @GetMapping("/{id}")
    public Example getById(@PathVariable("id") final String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final String id) {
        service.delete(id);
    }

}
