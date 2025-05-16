package com.mingri.service;

import com.mingri.dto.page.PageQuery;
import com.mingri.dto.sys.SysAddUserDTO;
import com.mingri.dto.sys.SysUpdateUserDTO;
import com.mingri.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingri.result.PageResult;
import com.mingri.vo.SysUserInfoVO;
import com.mingri.vo.SysUserListVO;

import java.util.Map;


public interface ISysMenuService extends IService<SysMenu> {

    PageResult<SysUserListVO> listUser(PageQuery pageQuery);

    boolean addUser(SysAddUserDTO sysAddUserDTO);

    boolean updateUser(SysUpdateUserDTO sysUpdateUserDTO);

    boolean deleteUser(String userid);

    SysUpdateUserDTO getUser(String userid);
}
