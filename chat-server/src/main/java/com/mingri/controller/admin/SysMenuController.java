package com.mingri.controller.admin;

import com.mingri.annotation.UrlLimit;
import com.mingri.dto.page.PageQuery;
import com.mingri.dto.sys.SysAddUserDTO;
import com.mingri.dto.sys.SysUpdateUserDTO;
import com.mingri.dto.user.SysUpdateDTO;
import com.mingri.result.PageResult;
import com.mingri.result.Result;
import com.mingri.service.ISysMenuService;
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
public class SysMenuController {

    @Resource
    private ISysMenuService iSysMenuService;

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
        PageResult<SysUserListVO> result = iSysMenuService.listUser(pageQuery);
        return Result.success(result);
    }


    @ApiOperation("添加用户")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/user/add")
    public Object addUser(@RequestBody SysAddUserDTO sysAddUserDTO) {
        boolean result = iSysMenuService.addUser(sysAddUserDTO);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("删除用户")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/user/delete")
    public Object deleteUser(@RequestParam String userid) {
        boolean result = iSysMenuService.deleteUser(userid);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("编辑用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @PutMapping("/user/update")
    public Object update(@RequestBody SysUpdateUserDTO sysUpdateUserDTO){
        log.info("编辑用户信息：{}", sysUpdateUserDTO);
        boolean result = iSysMenuService.updateUser(sysUpdateUserDTO);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("获取用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @GetMapping("/user/get")
    public Object getUserById(@RequestParam  String userid){
        SysUpdateUserDTO result = iSysMenuService.getUser(userid);
        return Result.success(result);
    }
















//    @Autowired
//    private ReportService reportService;
//
//    /**
//     * 导出数据报表
//     * @param response
//     */
//    @GetMapping("/export")
//    @ApiOperation("导出数据报表")
//    public void export(HttpServletResponse response){
//        reportService.exportClockData(response);
//    }


}
