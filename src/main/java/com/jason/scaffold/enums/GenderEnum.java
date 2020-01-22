package com.jason.scaffold.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.jason.scaffold.enums.base.ValueEnum;

/**
 * 性别枚举
 */
public enum GenderEnum implements ValueEnum {

    FEMALE(0, "女"),
    MALE(0, "男");

    @EnumValue
    private Integer code;
    private String text;

    GenderEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
