package com.mingri.controller.common;

import cn.hutool.core.util.IdUtil;
import com.mingri.exception.BaseException;
import com.mingri.result.Result;
import com.mingri.service.CommonService;
import com.mingri.utils.MinioUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/api/v1/common")
@Api(tags = "公共接口")
@Slf4j
public class CommonController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private MinioUtil minioUtil;

        @ApiOperation("发送邮箱验证码")
        @GetMapping("/get-code")
        public Result<String> sendEmailCaptcha(String email) {
            commonService.sendEmailCaptcha(email);
            return Result.success("发送成功");
        }

    @ApiOperation("上传图片")
//    @PreAuthorize("hasAuthority('sys:notify')")
    @PostMapping("/uploadImage")
    public Object addNotifyWithImage(@NotNull(message = "图片不能为空~") @RequestParam("file") MultipartFile file)
    {
        String url;
        try {
            url = minioUtil.upload(file.getInputStream(), "notify/" + IdUtil.randomUUID(), file.getContentType(), file.getSize());
        } catch (Exception e) {
            throw new BaseException("图片上传失败~");
        }
        return Result.success(url);
    }
}

