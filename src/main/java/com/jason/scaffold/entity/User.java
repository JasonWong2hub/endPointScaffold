package com.jason.scaffold.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jason.scaffold.entity.base.BaseEntity;
import com.jason.scaffold.enums.AchievementEnum;
import com.jason.scaffold.enums.GenderEnum;
import com.jason.scaffold.enums.TrueFalseEnum;
import lombok.Data;

/**
 * 用户信息
 */
@Data
@TableName("ith_admin_user")
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 战绩
     */
    private AchievementEnum achievement;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 微信openId
     */
    private String openid;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * 状态
     */
    private TrueFalseEnum status;

}
