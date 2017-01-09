package jp.bikon.service.impl;

import jp.bikon.model.Example;
import jp.bikon.repository.ExampleRepository;
import jp.bikon.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository repository;

    @Autowired
    public ExampleServiceImpl(final ExampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Example create(final Example entity) {
        return repository.save(entity);
    }

    @Override
    public Example update(final Example entity) {
        return repository.save(entity);
    }

    @Override
    public Example getById(final String id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(final String id) {
        repository.delete(id);
    }

    @Override
    public boolean exists(final String id) {
        return repository.exists(id);
    }
}
