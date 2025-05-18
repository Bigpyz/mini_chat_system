package com.mingri.dto.admin;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "添加用户对象")
public class SysAddUserDTO {

    @ApiModelProperty("用户名")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty("昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty("用户类型（0管理员，1普通用户，2机器人）")
    @TableField(value = "user_type")
    private Integer type;


}
