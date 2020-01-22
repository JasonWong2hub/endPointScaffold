package com.jason.scaffold.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.jason.scaffold.enums.base.ValueEnum;

/**
 * 性别枚举
 */
public enum TrueFalseEnum implements ValueEnum {

    /**
     * 是、可用、表肯定
     */
    FALSE(0, "是"),

    /**
     * 否、禁用、表否定
     */
    TRUE(1, "否");

    @EnumValue
    private Integer code;
    private String text;

    TrueFalseEnum(Integer code, String text) {
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
