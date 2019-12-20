package com.jason.scaffold.service.impl;

import com.jason.scaffold.entity.User;
import com.jason.scaffold.mapper.UserMapper;
import com.jason.scaffold.service.TestService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    private static final String redisPrefix = "user:";

    @Override
    public int saveTest() {
        User jason = new User();
        jason.setName("Jason");
        jason.setAge(25);
        return userMapper.save(jason);
    }

    @Override
    public User selectTest() {
        User user = userMapper.selectTop1();
        if (user!=null) {
            redisTemplate.opsForValue().set(redisPrefix + user.getId(), user, 1 , TimeUnit.MINUTES);
            User cache = (User) redisTemplate.opsForValue().get(redisPrefix + user.getId());
            System.out.println(cache);
        }
        return user;
    }
}
