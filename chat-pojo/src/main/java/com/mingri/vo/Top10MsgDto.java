package com.mingri.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Top10MsgDto {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "今日消息数量")
    private int num;
}
