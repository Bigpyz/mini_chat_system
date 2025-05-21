package com.mingri.controller.admin;

import cn.hutool.core.util.IdUtil;
import com.mingri.dto.notify.SysNotifyDTO;
import com.mingri.dto.notify.SysUpdateNotifyDTO;
import com.mingri.exception.BaseException;
import com.mingri.result.Result;
import com.mingri.service.INotifyService;
import com.mingri.utils.MinioUtil;
import com.mingri.vo.SysGetNotifyVo;
import com.mingri.vo.SysNotifyListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
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
@Api(tags = "后台通知管理接口")
@RequestMapping("/api/v1/admin/notify")
public class NotifyController {

    @Resource
    private INotifyService notifyService;
    @Resource
    private MinioUtil minioUtil;

    @ApiOperation("添加文本通知")
    @PreAuthorize("hasAuthority('sys:notify')")
    @PostMapping("/add")
    public Object addNotify(@RequestBody SysNotifyDTO sysNotifyDTO) {
        boolean result = notifyService.addNotify(sysNotifyDTO);
        return Result.ResultByFlag(result);
    }

    @ApiOperation("添加图片通知")
    @PreAuthorize("hasAuthority('sys:notify')")
    @PostMapping("/addWithImage")
    public Object addNotifyWithImage(@NotNull(message = "图片不能为空~") @RequestParam("file") MultipartFile file,
                            @NotNull(message = "标题不能为空~") @RequestParam("title") String title,
                            @NotNull(message = "内容不能为空~") @RequestParam("content") String content)
    {
        String url;
        try {
            url = minioUtil.upload(file.getInputStream(), "notify/" + IdUtil.randomUUID(), file.getContentType(), file.getSize());
        } catch (Exception e) {
            throw new BaseException("图片上传失败~");
        }
        boolean result = notifyService.addNotifyWithImage(url, title, content);
        return Result.ResultByFlag(result);
    }

    @ApiOperation("删除通知")
    @PreAuthorize("hasAuthority('sys:notify')")
    @PostMapping("/delete/{id}")
    public Object deleteNotify(@PathVariable String id) {
        boolean result = notifyService.deleteNotify(id);
        return Result.ResultByFlag(result);
    }


    @ApiOperation("更新通知")
    @PreAuthorize("hasAuthority('sys:notify')")
    @PostMapping("/update")
    public Object updateNotify(@RequestBody SysUpdateNotifyDTO sysUpdateNotifyDTO) {
        boolean result = notifyService.updateNotify(sysUpdateNotifyDTO);
        return Result.ResultByFlag(result);
    }

    @ApiOperation("查询所有通知")
    @PreAuthorize("hasAuthority('sys:notify')")
    @GetMapping("/list")
    public Object listNotify() {
        List<SysNotifyListVO> result = notifyService.listNotify();
        return Result.success(result);
    }

    @ApiOperation("查询单个通知")
    @PreAuthorize("hasAuthority('sys:notify')")
    @GetMapping("/get/{id}")
    public Object getNotify(@PathVariable String id) {
        SysGetNotifyVo result = notifyService.getNotify(id);
        return Result.success(result);
    }


}
