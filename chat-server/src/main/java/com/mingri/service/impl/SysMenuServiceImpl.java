package com.mingri.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingri.constant.MessageConstant;
import com.mingri.constant.PasswordConstant;
import com.mingri.dto.page.PageQuery;
import com.mingri.dto.admin.SysAddUserDTO;
import com.mingri.dto.admin.SysUpdateUserDTO;
import com.mingri.entity.SysMenu;
import com.mingri.entity.SysUser;
import com.mingri.enumeration.UserStatus;
import com.mingri.exception.BaseException;
import com.mingri.mapper.SysMenuMapper;
import com.mingri.result.PageResult;
import com.mingri.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingri.utils.BeanUtils;
import com.mingri.vo.SysUserListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Slf4j
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Resource
    private SysUserServiceImpl  sysUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PageResult<SysUserListVO> listUser(PageQuery pageQuery) {
        Page<SysUser> page = pageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<SysUser> p = sysUserService.lambdaQuery()
                .ne(SysUser::getDelFlag, -1)
                .page(page);
        return PageResult.of(p, user -> {
            SysUserListVO vo = BeanUtils.copyProperties(user, SysUserListVO.class);
            return vo;
        });
    }

    @Override
    public boolean addUser(SysAddUserDTO sysAddUserDTO) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(sysAddUserDTO, user);
        user.setId(IdUtil.simpleUUID());
        user.setStatus(UserStatus.NORMAL);
        user.setBadge(Collections.singletonList("clover"));
        user.setPassword(passwordEncoder.encode(PasswordConstant.DEFAULT_PASSWORD));

        return sysUserService.save(user);
    }

    @Override
    public boolean updateUser(SysUpdateUserDTO sysUpdateUserDTO) {
        SysUser sysUser = sysUserService.lambdaQuery().eq(SysUser::getUserName, sysUpdateUserDTO.getUserName()).one();
        if (sysUser != null) {
            throw new BaseException(MessageConstant.ACCOUNT_EXIST);
        }
        SysUser user = new SysUser();
        BeanUtils.copyProperties(sysUpdateUserDTO, user);
        return sysUserService.updateById(user);
    }

    @Override
    public boolean deleteUser(String userid) {
        SysUser user = sysUserService.getById(userid);
        user.setDelFlag(UserStatus.DELETE.getCode());
        return sysUserService.updateById(user);
    }

    @Override
    public SysUpdateUserDTO getUser(String userid) {
        SysUser sysUser = sysUserService.getById(userid);
        log.info("获取到该用户:{}", sysUser);
        SysUpdateUserDTO sysUpdateUserDTO = new SysUpdateUserDTO();
        BeanUtils.copyProperties(sysUser, sysUpdateUserDTO);
        return sysUpdateUserDTO;
    }


}
