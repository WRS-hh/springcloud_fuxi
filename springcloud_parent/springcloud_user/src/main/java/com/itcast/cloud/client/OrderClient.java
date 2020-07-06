package com.itcast.cloud.client;

import com.itcast.cloud.client.fallback.OrderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pojo.Order;

import java.util.List;

@FeignClient(name = "order-server", fallback = OrderFallback.class)
public interface OrderClient {


    @GetMapping("order/findOrderByUserId/{username}")
    public List<Order> findOrder(@PathVariable("username") String username);

}