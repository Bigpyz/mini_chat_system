package com.mingri.dto.admin;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "添加用户对象")
public class SysAddUserDTO {

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty("昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @NotNull(message = "邮箱不能为空")
    @ApiModelProperty("邮箱")
    @TableField(value = "email")
    private String email;

    @NotNull(message = "用户类型不能为空")
    @ApiModelProperty("用户类型（0管理员，1普通用户，2机器人）")
    @TableField(value = "user_type")
    private Integer type;


}
