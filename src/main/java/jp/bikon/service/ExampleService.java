package jp.bikon.service;

import jp.bikon.model.Example;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
public interface ExampleService {

    Example create(Example entity);

    Example update(Example entity);

    Example getById(String id);

    void delete(String id);

    boolean exists(String id);
}
