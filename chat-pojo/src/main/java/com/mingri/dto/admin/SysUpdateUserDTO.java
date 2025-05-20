package com.mingri.dto.admin;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "编辑用户对象")
public class SysUpdateUserDTO {

    @ApiModelProperty("主键值")
    @TableField(value = "id")
    @NotNull(message = "用户id不能为空")
    private String id;

    @ApiModelProperty("用户名")
    @TableField(value = "user_name")
    @NotNull(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("性别")
    @TableField(value = "sex")
    private Integer sex;

    @ApiModelProperty("邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty("用户类型（0管理员，1普通用户，2机器人）")
    @TableField(value = "user_type")
    @NotNull(message = "用户类型不能为空")
    private Integer type;

    @ApiModelProperty("用户状态（0正常，1禁用）")
    @TableField(value = "status")
    @NotNull(message = "用户状态不能为空")
    private Integer status;

}
