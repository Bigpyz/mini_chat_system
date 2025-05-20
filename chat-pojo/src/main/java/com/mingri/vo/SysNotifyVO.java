package com.mingri.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@ApiModel(value = "消息通知返回对象")
public class SysNotifyVO {

    @ApiModelProperty(value = "通知标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "通知内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
}

