package com.kungfudev.tutorials.springdatajpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 18h57
 */
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-jdbc.xml",
        "classpath:/META-INF/spring/spring-jpa.xml",
        "classpath:/META-INF/spring-data/spring-data-jpa.xml",
})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringDataJpaIntegrationTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    public void shouldPersistAndRetrieveEntity() throws Exception {

        testEntityRepository.save(new TestEntity(1, "Geoff"));

        TestEntity testEntity = testEntityRepository.findOne(1);

        Assert.assertEquals(new Integer(1), testEntity.getId());
        Assert.assertEquals("Geoff", testEntity.getName());

    }
}
