package com.jason.scaffold.service;

import com.jason.scaffold.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface TestService {

    int saveTest();

    User selectTest();
}
