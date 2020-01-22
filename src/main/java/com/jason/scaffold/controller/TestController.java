package com.jason.scaffold.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.jason.scaffold.entity.User;
import com.jason.scaffold.enums.TrueFalseEnum;
import com.jason.scaffold.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping("helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }

    @GetMapping("selectTest")
    public List<User> selectTest() {
        return userService.list();
    }

    @GetMapping("testSave")
    public void selectSave() {
        User user = new User();
        user.setUserName("Jason");
        user.setPassword("123");
        user.setSalt("123");
        user.setStatus(TrueFalseEnum.TRUE);
        userService.save(user);
    }

}
