package com.itcast.cloud.service;


import com.itcast.cloud.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    /**
     * 根据用户名查询订单列表
     *
     * @param username
     * @return
     */
    public List<Order> findOrderByUserId(String username) {
        //参数校验
        if (StringUtils.isBlank(username)) {
            log.error("OrderService findOrderByUserId is called error by username is null");
            throw new RuntimeException("参数非法");
        }

        //业务逻辑处理
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);

        //封装结果集参数
        List<Order> orders = orderMapper.selectByExample(example);
        if (orders == null) {
            orders = new ArrayList<>();
        }

        return orders;
    }
}
