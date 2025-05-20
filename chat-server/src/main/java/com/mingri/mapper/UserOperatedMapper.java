package com.mingri.mapper;

import com.mingri.entity.UserOperated;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingri.vo.UserOperatedVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户操作表 Mapper 接口
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-20
 */
@Mapper
public interface UserOperatedMapper extends BaseMapper<UserOperated> {


    List<UserOperatedVO> loginDetails();


}
