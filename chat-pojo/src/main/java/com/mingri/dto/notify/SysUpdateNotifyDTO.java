package com.mingri.dto.notify;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "消息更新对象")
public class SysUpdateNotifyDTO {

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "通知标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "通知内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "图片URL")
    @TableField("image")
    private String image;

    @ApiModelProperty(value = "是否发布")
    @TableField("status")
    private Boolean status;

}
