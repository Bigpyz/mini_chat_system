package com.mingri.mapper;

import com.mingri.entity.ChatList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface ChatListMapper extends BaseMapper<ChatList> {

    @Select("SELECT SUM(unread_count) FROM chat_list")
    Integer getUnReadNum();

}
