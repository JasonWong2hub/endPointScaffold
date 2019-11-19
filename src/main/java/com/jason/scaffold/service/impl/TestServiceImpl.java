package com.jason.scaffold.service.impl;

import com.jason.scaffold.entity.User;
import com.jason.scaffold.mapper.UserMapper;
import com.jason.scaffold.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int saveTest() {
        User jason = new User();
        jason.setName("Jason");
        jason.setAge(25);
        return userMapper.save(jason);
    }

    @Override
    public User selectTest() {
        return userMapper.selectTop1();
    }
}
