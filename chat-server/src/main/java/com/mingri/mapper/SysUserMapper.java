package com.mingri.mapper;

import com.mingri.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingri.vo.SysUserInfoVO;
import com.mingri.vo.SysUserListVO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;



@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户id获取用户信息
     **/
    @Select("SELECT * FROM sys_user WHERE id = #{userId}")
    @ResultMap("UserDtoResultMap")
    SysUserInfoVO getUserById(String userId);

    /**
     * 查询所有用户信息（Map集合--前端主页）
     **/
    @Select("SELECT * FROM sys_user ORDER BY user_type DESC")
    @MapKey("id")
    @ResultMap("UserDtoResultMap")
    Map<String, SysUserInfoVO> listMapUser();

    /**
     * 查询今日登录的用户数量
     **/
    @Select("SELECT COUNT(*) FROM sys_user WHERE DATE(login_time) = CURDATE()")
    Integer loginNum();

    /**
     * 查询所有用户信息（List集合--管理端用户列表）
     **/
    List<SysUserListVO> listAllUsers();
}
