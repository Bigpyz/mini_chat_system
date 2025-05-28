package com.mingri.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.mingri.dto.notify.SysNotifyDTO;
import com.mingri.dto.notify.SysUpdateNotifyDTO;
import com.mingri.entity.Notify;
import com.mingri.mapper.NotifyMapper;
import com.mingri.service.INotifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingri.utils.BeanUtils;
import com.mingri.vo.SysGetNotifyVo;
import com.mingri.vo.SysNotifyListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统通知表 服务实现类
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-20
 */
@Service
public class NotifyServiceImpl extends ServiceImpl<NotifyMapper, Notify> implements INotifyService {

    @Resource
    private NotifyMapper notifyMapper;

    /**
     * 删除通知
     **/
    @Override
    public boolean deleteNotify(String id) {
        return notifyMapper.deleteNotify(id);
    }


    /**
     * 查询所有 “启用” 的通知
     **/
    @Override
    //@DS("slave")
    public List<SysNotifyListVO> listNotify() {
        return notifyMapper.listNotify();
    }


    /**
     * 修改（更新）通知
     **/
    @Override
    public boolean updateNotify(SysUpdateNotifyDTO sysUpdateNotifyDTO) {
        Notify notify = new Notify();
        BeanUtils.copyProperties(sysUpdateNotifyDTO, notify);
        return notifyMapper.updateNotify(notify);
    }


    /**
     * 获取某条通知的信息
     **/
    @Override
    //@DS("slave")
    public SysGetNotifyVo getNotify(String id) {
        return notifyMapper.getNotify(id);
    }


    /**
     * 添加 图片 + 文字 的通知
     **/
    @Override
    public boolean addNotifyWithImage(String url, String title, String content) {
        Notify notify = new Notify();
        notify.setId(IdUtil.simpleUUID());
        notify.setTitle(title);
        notify.setContent(content);
        notify.setImage(url);
        notify.setStatus(true);
        return notifyMapper.saveNotify(notify);
    }

    @Override
    public Integer getNotifyNum() {
        return notifyMapper.getNotifyNum();
    }

    /**
     * 添加普通文本通知
     **/
    @Override
    public boolean addNotify(SysNotifyDTO sysNotifyDTO) {
        Notify notify = new Notify();
        BeanUtils.copyProperties(sysNotifyDTO, notify);
        notify.setId(IdUtil.simpleUUID());
        notify.setStatus(true);
        return notifyMapper.saveNotify(notify);
    }

}
