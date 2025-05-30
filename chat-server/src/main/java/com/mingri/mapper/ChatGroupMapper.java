package com.mingri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingri.entity.ChatGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 聊天群表 Mapper 接口
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-03
 */
@Mapper
public interface ChatGroupMapper extends BaseMapper<ChatGroup> {

}
