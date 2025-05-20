package com.mingri.service;

import com.mingri.dto.notify.SysNotifyDTO;
import com.mingri.dto.notify.SysUpdateNotifyDTO;
import com.mingri.entity.Notify;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingri.vo.SysNotifyVO;

import java.util.List;

/**
 * <p>
 * 系统通知表 服务类
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-20
 */
public interface INotifyService extends IService<Notify> {

    boolean addNotify(SysNotifyDTO sysNotifyDTO);

    boolean deleteNotify(String id);

    List<SysNotifyVO> listNotify();

    boolean updateNotify(SysUpdateNotifyDTO sysUpdateNotifyDTO);

    SysNotifyDTO getNotify(String id);
}
