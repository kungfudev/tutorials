package com.kungfudev.tutorials.springboot;

/**
 * User: Kevin W. Sewell
 * Date: 2014-07-30
 * Time: 11h56
 */
public class User {

    private Long id;

    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
