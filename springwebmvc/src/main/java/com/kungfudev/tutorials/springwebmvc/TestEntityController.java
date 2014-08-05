package com.kungfudev.tutorials.springwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 21h39
 */
@RestController
public class TestEntityController {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @RequestMapping(value = "/api/testEntities", method = RequestMethod.POST)
    public void save(@RequestBody TestEntity testEntity, HttpServletResponse httpServletResponse) {

        testEntityRepository.save(testEntity);

        httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
    }

    @RequestMapping(value = "/api/testEntities/{id}")
    public TestEntity save(@PathVariable("id") Integer id) {

        return testEntityRepository.findOne(id);
    }
}
