package jp.bikon.repository;

import jp.bikon.model.Example;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * Example using CouchbaseRepository. Also see CouchbasePagingAndSortingRepository.
 * @author jase
 */
public interface ExampleRepository extends CouchbaseRepository<Example, String> {
}
