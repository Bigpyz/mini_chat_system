package com.mingri.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mingri.enumeration.UserStatus;
import com.mingri.enumeration.UserTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
@ApiModel(description = "用户登录返回的数据格式")
public class SysUserListVO implements Serializable {

    @ApiModelProperty("主键值")
    @TableField(value = "id")
    private String id;

    @ApiModelProperty("用户名")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty("昵称")
    @TableField(value = "nick_name")
    private String nickName;

    @ApiModelProperty("性别")
    @TableField(value = "sex")
    private Integer sex;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty("用户类型（0管理员，1普通用户，2机器人）")
    @TableField(value = "user_type")
    private UserTypes type;

    @ApiModelProperty("用户账号状态（0正常，1禁用）")
    @TableField(value = "status")
    private UserStatus status;

    @ApiModelProperty("用户在线状态")
    private Boolean online = false;

    @ApiModelProperty("加入时长")
    private Long joinDays;

}
