package com.itcast.cloud.client.fallback;

import com.itcast.cloud.client.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pojo.Order;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderFallback implements OrderClient {


    @Override
    public List<Order> findOrder(String username) {

        log.error("OrderFallback findOrder is error for Hystrix username:{}", username);

        List<Order> list = new ArrayList<>();
        Order order = new Order();
        order.setId("-1");
        list.add(order);

        return list;
    }
}