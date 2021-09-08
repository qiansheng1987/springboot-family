package com.qs.libs.qstool.samples.controller;

import com.qs.libs.qstool.samples.service.AsyncService;
import com.qs.libs.qstoolcommon.enums.base.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 线程池测试
 *
 * @author qiansheng
 * @date 2021/9/7 下午4:17
 */
@RestController
@Slf4j
public class ThreadPoolController {

    @Resource(name = "poolAsyncService")
    private AsyncService asyncService;

    @GetMapping("/thread")
    public ApiResponse<Boolean> thread() {
        //调用service层的任务
        asyncService.executeAsync();
        return ApiResponse.success(true);
    }
}
