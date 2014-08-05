package com.kungfudev.tutorials.springjpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.*;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 18h57
 */
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-jdbc.xml",
        "classpath:/META-INF/spring/spring-jpa.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJpaIntegrationTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void shouldPersistAndRetrieveEntity() throws Exception {

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
