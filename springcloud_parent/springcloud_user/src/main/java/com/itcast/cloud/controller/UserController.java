package com.itcast.cloud.controller;

import com.itcast.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import response.UserOrderVo;



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

    /**
     * 查询用户信息和用户所有的订单列表
     * @param username
     * @return
     */
    @GetMapping("findOrderByUserId")
    public UserOrderVo findOrderByUserId(@RequestParam("username") String username) {
        return userService.findOrderByUserId(username);
    }
}
