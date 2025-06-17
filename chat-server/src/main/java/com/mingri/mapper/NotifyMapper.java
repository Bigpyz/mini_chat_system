package com.mingri.mapper;

import com.mingri.entity.Notify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingri.vo.SysGetNotifyVo;
import com.mingri.vo.SysNotifyListVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 系统通知表 Mapper 接口
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-20
 */
@Mapper
public interface NotifyMapper extends BaseMapper<Notify> {

    /**
     * 保存通知
     **/
    @Insert("INSERT INTO notify (id, title, content, image, status, create_time, update_time, create_by) " +
            "VALUES (#{id}, #{title}, #{content}, #{image}, #{status}, NOW(), NOW(), #{createBy})")
    boolean saveNotify(Notify notify);

    /**
     * 删除通知
     **/
    @Delete("DELETE FROM notify WHERE id = #{id}")
    boolean deleteNotify(String id);

    /**
     * 查询所有通知
     **/
    @Select("SELECT id, title, content, image, status, create_time, update_time, create_by " +
            "FROM notify ORDER BY create_time DESC")
    List<SysNotifyListVO> listNotify();

    /**
     * 编辑（更细通知）
     **/
    @Update("UPDATE notify SET title = #{title}, content = #{content}, image = #{image}, " +
            "status = #{status}, update_time = NOW() WHERE id = #{id}")
    boolean updateNotify(Notify notify);

    /**
     * 获取某条通知信息
     **/
    @Select("SELECT id, title, content, image, status, create_time, update_time, create_by " +
            "FROM notify WHERE id = #{id}")
    SysGetNotifyVo getNotify(String id);

    @Select("SELECT COUNT(*) FROM notify ")
    Integer getNotifyNum();


}
