package com.kungfudev.tutorials.springwebmvc;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 18h56
 */
@Entity
public class TestEntity implements Serializable {

    @Id
    private Integer id;

    private String name;

    public TestEntity() {
    }

    public TestEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
