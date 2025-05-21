package com.mingri.service;

import com.mingri.dto.admin.SysAddUserDTO;
import com.mingri.dto.admin.SysUpdateUserDTO;
import com.mingri.dto.page.PageQuery;
import com.mingri.dto.user.SysUpdateDTO;
import com.mingri.dto.user.SysUserLoginDTO;
import com.mingri.dto.user.SysUserRegisterDTO;
import com.mingri.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingri.result.PageResult;
import com.mingri.vo.SysUserInfoVO;
import com.mingri.vo.SysUserListVO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface ISysUserService extends IService<SysUser> {

    // 客户端
    SysUser login(SysUserLoginDTO userLoginDTO);

    void register(SysUserRegisterDTO userRegisterDTO);

    boolean logout();

    SysUserInfoVO getUserById(String userId);

    List<String> onlineWeb();

    Map<String, SysUserInfoVO> listMapUser();

    void online(String userId);

    void offline(String userId);

    void deleteExpiredUsers(LocalDate expirationDate);

    void updateUserBadge(String id);

    void initBotUser();

    boolean updateSelf(SysUpdateDTO sysUpdateDTO);




    // 管理端
    PageResult<SysUserListVO> listUser(PageQuery pageQuery);

    boolean addUser(SysAddUserDTO sysAddUserDTO);

    boolean updateUser(SysUpdateUserDTO sysUpdateUserDTO);

    boolean deleteUser(String userid);

    SysUpdateUserDTO getUser(String userid);

    SysUser validateLogin(SysUserLoginDTO userLoginDTO);

    boolean setAdmin(String userid);
}
