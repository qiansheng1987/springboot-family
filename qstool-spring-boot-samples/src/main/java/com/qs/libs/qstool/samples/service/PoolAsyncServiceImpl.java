package com.qs.libs.qstool.samples.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author qiansheng@yunji.ai
 * @date 2021/9/8 下午1:35
 */
@Service("poolAsyncService")
@Slf4j
public class PoolAsyncServiceImpl implements AsyncService{

    @Override
    @Async("asyncTaskExecutor")
    public void executeAsync() {
        log.error("当前运行的线程名称：{}", Thread.currentThread().getName());
    }
}
