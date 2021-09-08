package com.qs.libs.toolautoconfigure.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置类
 *
 * @author qiansheng
 * @date 2021/9/7 下午3:30
 */
@Slf4j
@Configuration
@EnableAsync
@EnableConfigurationProperties(ThreadPoolProperties.class)
public class ThreadPoolConfiguration implements AsyncConfigurer {

    @Autowired
    private ThreadPoolProperties threadPoolProperties;

    @Bean("asyncTaskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());
        // 设置最大线程数
        executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
        // 设置队列容量
        executor.setQueueCapacity(threadPoolProperties.getQueueCapacity());
        // 设置允许的空闲时间（秒）
        executor.setKeepAliveSeconds(threadPoolProperties.getKeepAlive());
        // 设置默认线程名称
        executor.setThreadNamePrefix("thread-" + threadPoolProperties.getThreadNamePrefix());
        // 设置拒绝策略rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
