package com.jason.scaffold.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.jason.scaffold.enums.base.ValueEnum;

/**
 * 战绩枚举
 */
public enum AchievementEnum implements ValueEnum {

    ONE(1, "一星"),
    TWO(2, "二星"),
    THREE(3, "三星"),
    FOUR(4, "四星"),
    FIVE(5, "五星");

    @EnumValue
    private Integer code;
    private String text;

    AchievementEnum(Integer code, String text) {
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
