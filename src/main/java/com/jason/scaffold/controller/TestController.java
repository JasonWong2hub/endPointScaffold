package com.jason.scaffold.controller;

import com.jason.scaffold.entity.User;
import com.jason.scaffold.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }

    @GetMapping("saveTest")
    public int saveTest() {
        return testService.saveTest();
    }

    @GetMapping("selectTest")
    public User selectTest() {
        return testService.selectTest();
    }

}
