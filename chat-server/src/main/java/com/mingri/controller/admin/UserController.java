package com.mingri.controller.admin;

import com.mingri.annotation.UrlLimit;
import com.mingri.constant.JwtClaimsConstant;
import com.mingri.constant.type.LimitKeyType;
import com.mingri.dto.admin.SysAddUserDTO;
import com.mingri.dto.admin.SysUpdateUserDTO;
import com.mingri.dto.user.SysUserLoginDTO;
import com.mingri.entity.SysUser;
import com.mingri.properties.JwtProperties;
import com.mingri.result.Result;
import com.mingri.service.ISysUserService;
import com.mingri.utils.CacheUtil;
import com.mingri.utils.JwtUtil;
import com.mingri.vo.SysUserListVO;
import com.mingri.vo.SysUserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Api(tags = "后台用户管理接口")
@RestController
@RequestMapping("/api/v1/admin/user")
public class UserController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    CacheUtil cacheUtil;
    @Autowired
    private JwtProperties jwtProperties;


    @UrlLimit(keyType = LimitKeyType.IP)
    @ApiOperation("管理端登录")
    @PostMapping("/login")
    public Result<SysUserLoginVO> login(@RequestBody SysUserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);

        SysUser loginUser = sysUserService.validateLogin(userLoginDTO);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, loginUser.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getSecretKey(),
                jwtProperties.getExpireTime(),
                claims);

        cacheUtil.putUserSessionCache(String.valueOf(loginUser.getId()), token);
        SysUserLoginVO userLoginVO = SysUserLoginVO.builder()
                .userId(loginUser.getId())
                .userName(loginUser.getUserName())
                .type(loginUser.getUserType())
                .email(loginUser.getEmail())
                .avatar(loginUser.getAvatar())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }


    @ApiOperation("查询所有用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @GetMapping("/list")
    public Object listUser() {
        List<SysUserListVO> result = sysUserService.listUser();
        return Result.success(result);
    }


    @ApiOperation("添加用户")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/add")
    public Object addUser(@RequestBody SysAddUserDTO sysAddUserDTO) {
        boolean result = sysUserService.addUser(sysAddUserDTO);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("删除用户")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/delete/{userid}")
    public Object deleteUser(@PathVariable String userid) {
        boolean result = sysUserService.deleteUser(userid);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("编辑用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/update")
    public Object update(@RequestBody SysUpdateUserDTO sysUpdateUserDTO){
        log.info("编辑用户信息：{}", sysUpdateUserDTO);

        boolean result = sysUserService.updateUser(sysUpdateUserDTO);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("获取用户信息")
    @PreAuthorize("hasAuthority('sys:user')")
    @GetMapping("/get/{userid}")
    public Object getUserById(@PathVariable String userid){
        SysUpdateUserDTO result = sysUserService.getUser(userid);
        return Result.success(result);
    }

    @ApiOperation("设为管理员")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/setAdmin/{userid}")
    public Object setAdmin(@PathVariable  String userid){
        boolean result = sysUserService.setAdmin(userid);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("撤销管理员")
    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/cancelAdmin/{userid}")
    public Object cancelAdmin(@PathVariable  String userid){
        boolean result = sysUserService.cancelAdmin(userid);
        return Result.ResultByFlag(result);
    }



    @ApiOperation("统计5月22号之后登录用户的数量")
//    @PreAuthorize("hasAuthority('sys:user')")
    @PostMapping("/get/loginNum")
    public Object getLoginNum(){
        Integer result = sysUserService.getLoginNum();
        return Result.success(result);
    }


}
