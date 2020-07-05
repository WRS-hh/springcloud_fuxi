package com.itcast.cloud.controller;

import com.itcast.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 根据用户名查询订单列表
     */
    @GetMapping("findOrderByUserId/{username}")
    public List<Order> findOrder(@PathVariable("username") String username) {

        return orderService.findOrderByUserId(username);
    }
}
