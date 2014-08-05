package com.kungfudev.tutorials.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Kevin W. Sewell
 * Date: 2014-07-30
 * Time: 11h55
 */
@RestController
public class UserController {

    @RequestMapping("/service/users/{userId}")
    public User getUser(@PathVariable("userId") Long id) {
        return new User(id, "Test User");
    }

    @RequestMapping("/service/user")
    public User getUser() {
        return new User(1L, "Test User");
    }
}
