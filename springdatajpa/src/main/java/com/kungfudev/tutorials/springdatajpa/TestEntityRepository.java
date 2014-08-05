package com.kungfudev.tutorials.springdatajpa;

import org.springframework.data.repository.CrudRepository;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 19h48
 */
public interface TestEntityRepository extends CrudRepository<TestEntity, Integer> {
}
