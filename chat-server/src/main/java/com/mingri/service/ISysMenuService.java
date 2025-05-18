package com.mingri.service;

import com.mingri.dto.page.PageQuery;
import com.mingri.dto.admin.SysAddUserDTO;
import com.mingri.dto.admin.SysUpdateUserDTO;
import com.mingri.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingri.result.PageResult;
import com.mingri.vo.SysUserListVO;


public interface ISysMenuService extends IService<SysMenu> {

    PageResult<SysUserListVO> listUser(PageQuery pageQuery);

    boolean addUser(SysAddUserDTO sysAddUserDTO);

    boolean updateUser(SysUpdateUserDTO sysUpdateUserDTO);

    boolean deleteUser(String userid);

    SysUpdateUserDTO getUser(String userid);
}
