package com.itcast.cloud.service;

import com.itcast.cloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findUser(String username) {

        return userMapper.selectByPrimaryKey(username);
    }
}
