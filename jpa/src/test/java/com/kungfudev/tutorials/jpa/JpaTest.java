package com.kungfudev.tutorials.jpa;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 18h57
 */
public class JpaTest {

    @Test
    public void shouldPersistAndRetrieveEntity() throws Exception {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("com.kungfudev.tutorials.jpa.pu");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            entityManager.persist(new TestEntity(1, "Geoff"));

            TestEntity testEntity = entityManager.find(TestEntity.class, 1);

            Assert.assertEquals(new Integer(1), testEntity.getId());
            Assert.assertEquals("Geoff", testEntity.getName());

        } finally {

            entityManager.close();
        }
    }
}
