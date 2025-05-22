package com.mingri.controller.admin;

import com.mingri.annotation.UrlResource;
import com.mingri.result.Result;
import com.mingri.service.IUserOperatedService;
import com.mingri.vo.SysNumInfo;
import com.mingri.vo.Top10MsgDto;
import com.mingri.vo.UserOperatedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Api(tags = "后台主页管理接口")
@RestController
@RequestMapping("/api/v1/admin/index")
public class StatisticController {

    @Resource
    IUserOperatedService userOperatedService;


    @ApiOperation("今日登录详情")
    @PreAuthorize("hasAuthority('sys:index')")
    @GetMapping("/login/details")
    @UrlResource("admin")
    public Object loginDetails() {
        List<UserOperatedVO> result = userOperatedService.loginDetails();
        return Result.success(result);
    }


    @ApiOperation("今日活跃数量信息")
    @PreAuthorize("hasAuthority('sys:index')")
    @GetMapping("/num/info")
    @UrlResource("admin")
    public Object numInfo() {
        SysNumInfo result = userOperatedService.numInfo();
        return Result.success(result);
    }


    @ApiOperation("发送消息top10用户")
    @PreAuthorize("hasAuthority('sys:index')")
    @GetMapping("/top10")
    @UrlResource("admin")
    public Object top10Msg() {
        List<Top10MsgDto> result = userOperatedService.getTop10Msg();
        return Result.success(result);
    }


}
