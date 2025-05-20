package com.mingri.mapper;

import com.mingri.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingri.vo.Top10MsgDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import java.util.List;



@Mapper
public interface MessageMapper extends BaseMapper<Message> {


    @Select("SELECT * " +
            "      FROM `message` " +
            "      WHERE (`from_id` = #{userId} AND `to_id` = #{targetId}) " +
            "         OR (`from_id` = #{targetId} AND `to_id` = #{userId}) " +
            "         OR (`source` = 'group' AND `to_id` = #{targetId}) " +
            "      ORDER BY `create_time` DESC LIMIT #{index}, #{num} ")
    @ResultMap("RecordVoMap")
    List<Message> record(String userId, String targetId, int index, int num);

    @Select("SELECT * " +
            "FROM `message` " +
            "WHERE (`from_id` = #{userId} AND `to_id` = #{targetId}) " +
            "   OR (`from_id` = #{targetId} AND `to_id` = #{userId}) " +
            "ORDER BY `create_time` DESC LIMIT 1")
    Message getPreviousShowTimeMsg(String userId, String targetId);

    @Select("SELECT COUNT(*) FROM message WHERE DATE(create_time) = CURDATE()")
    Integer countTodayMessages();


    @Select("SELECT u.user_name, u.avatar, COUNT(m.id) AS num " +
            "FROM message m " +
            "JOIN sys_user u ON m.from_id = u.id " +
            "WHERE m.create_time >= CURDATE() " +
            "  AND m.create_time < DATE_ADD(CURDATE(), INTERVAL 1 DAY) " +
            "GROUP BY u.id, u.user_name, u.avatar " +
            "ORDER BY num DESC " +
            "LIMIT 10")
    List<Top10MsgDto> getTop10Msg();

}


