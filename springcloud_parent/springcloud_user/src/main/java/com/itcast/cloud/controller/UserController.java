package com.itcast.cloud.controller;

import com.itcast.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询用户信息
     *
     * @param username
     * @return
     */
    @GetMapping("findUserById/{username}")
    public User findUser(@PathVariable("username") String username) {
        return userService.findUser(username);
    }
}
