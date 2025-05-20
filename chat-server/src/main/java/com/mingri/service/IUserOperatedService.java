package com.mingri.service;

import com.mingri.entity.UserOperated;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingri.vo.SysNumInfo;
import com.mingri.vo.Top10MsgDto;
import com.mingri.vo.UserOperatedVO;

import java.util.List;

/**
 * <p>
 * 用户操作表 服务类
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-20
 */
public interface IUserOperatedService extends IService<UserOperated> {

    SysNumInfo numInfo();

    List<UserOperatedVO> loginDetails();

    boolean recordLogin(String id, String ip);

    List<Top10MsgDto> getTop10Msg();
}
