package com.jason.scaffold.mapper;

import com.jason.scaffold.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectTop1();

    int save(@Param("user") User user);
}
