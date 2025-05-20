package com.mingri.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value="SysMenu对象", description="权限表")
public class SysMenu implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "菜单名")
    private String menuName;

    @ApiModelProperty(value = "菜单状态（0正常 1停用）")
    private String status;

    @ApiModelProperty(value = "权限标识")
    private String perms;

    @ApiModelProperty(value = "创建人的用户id")
    @TableField(value = "create_By",fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    @TableField(value = "update_By",fill = FieldFill.UPDATE)
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;


}
