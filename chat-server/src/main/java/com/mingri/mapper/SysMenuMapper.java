package com.mingri.mapper;

import com.mingri.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    //查找权限
    List<String> selectPermsByUserId(String id);

}
