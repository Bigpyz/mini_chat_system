package com.mingri.enumeration;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;


public enum UserStatus {

    NORMAL(0, "正常"),
    FREEZE(1, "禁用"),
    DELETE(-1,  "被删除");

    @EnumValue
    @Getter
    @JsonValue // 枚举值序列化成json时，只返回code
    private final Integer code;
    private final String desc;

    UserStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
