package com.jason.scaffold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.scaffold.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {


}
