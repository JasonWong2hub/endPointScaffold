package com.jason.scaffold.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jason.scaffold.enums.AchievementEnum;
import com.jason.scaffold.enums.GenderEnum;
import lombok.Data;

@Data
public class AuthUserVO {

    private String id;
    private String userName;
    private String nickName;
    private Byte age;
    private GenderEnum genderEnum;
    private String phone;
    private String email;
    private AchievementEnum achievement;
    private String password;
    private String salt;
    private String avatar;

}
