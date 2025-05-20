package com.mingri.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mingri.constant.type.UserOperatedType;
import com.mingri.entity.UserOperated;
import com.mingri.mapper.MessageMapper;
import com.mingri.mapper.SysUserMapper;
import com.mingri.mapper.UserOperatedMapper;
import com.mingri.service.IUserOperatedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingri.service.WebSocketService;
import com.mingri.vo.SysNumInfo;
import com.mingri.vo.Top10MsgDto;
import com.mingri.vo.UserOperatedVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户操作表 服务实现类
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-20
 */
@Service
public class UserOperatedServiceImpl extends ServiceImpl<UserOperatedMapper, UserOperated> implements IUserOperatedService {

    @Resource
    UserOperatedMapper userOperatedMapper;
    @Resource
    SysUserMapper sysUserMapper;
    @Resource
    WebSocketService webSocketService;
    @Resource
    MessageMapper messageMapper;


    @Override
    public SysNumInfo numInfo() {
        SysNumInfo numInfo = new SysNumInfo();
        Integer loginNum =  sysUserMapper.loginNum();
        Integer onlineNum = webSocketService.getOnlineNum();
        Integer msgNum = messageMapper.countTodayMessages();
        numInfo.setLoginNum(loginNum);
        numInfo.setOnlineNum(onlineNum);
        numInfo.setMsgNum(msgNum);
        return numInfo;
    }

    @Override
    public List<UserOperatedVO> loginDetails() {
        List<UserOperatedVO> result = userOperatedMapper.loginDetails();
        return result;
    }

    @Override
    public boolean recordLogin(String id, String ip) {
        UserOperated operated = new UserOperated();
        operated.setId(IdUtil.randomUUID());
        operated.setUserId(id);
        operated.setAddress(ip);
        operated.setType(UserOperatedType.Login);
        return save(operated);
    }

    @Override
    public List<Top10MsgDto> getTop10Msg() {
        List<Top10MsgDto> result = messageMapper.getTop10Msg();
        return result;    }


}
