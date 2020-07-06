package com.itcast.cloud.service;

import com.itcast.cloud.client.OrderClient;
import com.itcast.cloud.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Order;
import pojo.User;
import response.OrderVo;
import response.UserOrderVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderClient orderClient;

    @Autowired
    Mapper dozerMapper;


    public User findUser(String username) {

        return userMapper.selectByPrimaryKey(username);
    }

    public UserOrderVo findOrderByUserId(String username) {  // {user, list}
        // 1 参数校验
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("参数非法");
        }
        // 2.1 查询用户信息
        User user = this.findUser(username);
        if (user == null) {
            throw new RuntimeException("无当前用户信息");
        }
        // 2.2 根据用户名查询订单列表， 基于feign
        List<Order> orderList = orderClient.findOrder(user.getUsername());

        //结果处理封装
        UserOrderVo userOrderVo = new UserOrderVo();

        //BeanUtils.copyProperties(user, userOrderVo);
        userOrderVo = dozerMapper.map(user, UserOrderVo.class);

        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderVo orderVo = new OrderVo();
            BeanUtils.copyProperties(order, orderVo);
            orderVoList.add(orderVo);
        }
        userOrderVo.setOrderList(orderVoList);

        return userOrderVo;
    }
}
