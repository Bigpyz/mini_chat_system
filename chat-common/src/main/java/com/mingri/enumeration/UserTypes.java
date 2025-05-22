package com.mingri.enumeration;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum UserTypes {

    admin(0, "admin"),
    user(1, "user"),
    bot(2, "bot");

    @EnumValue
    @Getter
    private final Integer code;

    @JsonValue // 枚举值序列化成json时，只返回code
    @Getter
    private final String desc;

    UserTypes(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
