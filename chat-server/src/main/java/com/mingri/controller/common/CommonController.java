package com.mingri.controller.common;

import com.mingri.result.Result;
import com.mingri.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



    /**
     * @Description: 发送邮箱验证码
     * @Author: mingri31164
     * @Date: 2025/1/20 0:01
     **/
        @ApiOperation("发送邮箱验证码")
        @GetMapping("/get-code")
        public Result<String> sendEmailCaptcha(String email) {
            commonService.sendEmailCaptcha(email);
            return Result.success("发送成功");
        }

}
