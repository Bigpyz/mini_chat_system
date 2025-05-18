package com.mingri.controller.admin;

import com.mingri.dto.page.PageQuery;
import com.mingri.dto.admin.SysAddUserDTO;
import com.mingri.dto.admin.SysUpdateUserDTO;
import com.mingri.result.PageResult;
import com.mingri.result.Result;
import com.mingri.service.ISysMenuService;
import com.mingri.service.ISysUserService;
import com.mingri.vo.SysUserListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@Api(tags = "后台管理接口")
@RestController
@RequestMapping("/api/v1/sys")
public class UserController {

    @Resource
    private ISysUserService sysUserService;

    /**
     * 自定义权限认证注解测试
     **/
//    @RequestMapping("/hello")
//    @PreAuthorize("hasAuthority('system:dept:list')") //单个权限
////    @PreAuthorize("hasAnyAuthority('user','admin')") //多个权限（只要有其中之一）
////    @PreAuthorize("hasRole('user')") //内部拼接(ROLE_user)比对
////    @PreAuthorize("@myEx.hasAuthority('system:dept:list')") //自定义权限校验
//    public String hello(){
//        return "欢迎，开始你新的学习旅程吧";
//    }

    @ApiOperation("查询所有用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/user/list")
    public Object listUser(@RequestBody PageQuery pageQuery) {
        PageResult<SysUserListVO> result = sysUserService.listUser(pageQuery);
        return Result.success(result);
    }


    @ApiOperation("添加用户")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/user/add")
    public Object addUser(@RequestBody SysAddUserDTO sysAddUserDTO) {
        boolean result = sysUserService.addUser(sysAddUserDTO);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("删除用户")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/user/delete")
    public Object deleteUser(@RequestParam String userid) {
        boolean result = sysUserService.deleteUser(userid);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("编辑用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @PutMapping("/user/update")
    public Object update(@RequestBody SysUpdateUserDTO sysUpdateUserDTO){
        log.info("编辑用户信息：{}", sysUpdateUserDTO);
        boolean result = sysUserService.updateUser(sysUpdateUserDTO);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("获取用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @GetMapping("/user/get")
    public Object getUserById(@RequestParam  String userid){
        SysUpdateUserDTO result = sysUserService.getUser(userid);
        return Result.success(result);
    }



}
