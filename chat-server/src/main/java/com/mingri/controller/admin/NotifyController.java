package com.mingri.controller.admin;

import com.mingri.dto.notify.SysNotifyDTO;
import com.mingri.dto.notify.SysUpdateNotifyDTO;
import com.mingri.dto.page.PageQuery;
import com.mingri.result.Result;
import com.mingri.service.INotifyService;
import com.mingri.vo.SysNotifyVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统通知表 前端控制器
 * </p>
 *
 * @author mingri31164
 * @since 2025-05-20
 */
@RestController
@RequestMapping("/api/v1/admin/notify")
public class NotifyController {

    @Resource
    private INotifyService notifyService;

    @ApiOperation("添加通知")
    @PostMapping("/add")
    public Object addNotify(@RequestBody SysNotifyDTO sysNotifyDTO) {
        boolean result = notifyService.addNotify(sysNotifyDTO);
        return Result.ResultByFlag(result);
    }

    @ApiOperation("删除通知")
    @PostMapping("/delete")
    public Object deleteNotify(@RequestParam String id) {
        boolean result = notifyService.deleteNotify(id);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("更新通知")
    @PostMapping("/update")
    public Object updateNotify(@RequestBody SysUpdateNotifyDTO sysUpdateNotifyDTO) {
        boolean result = notifyService.updateNotify(sysUpdateNotifyDTO);
        return Result.ResultByFlag(result);
    }

    @ApiOperation("查询所有通知")
    @GetMapping("/list")
    public Object listNotify() {
        List<SysNotifyVO> result = notifyService.listNotify();
        return Result.success(result);
    }

    @ApiOperation("查询单个通知")
    @GetMapping("/get")
    public Object getNotify(@RequestParam String id) {
        SysNotifyDTO result = notifyService.getNotify(id);
        return Result.success(result);
    }


}
