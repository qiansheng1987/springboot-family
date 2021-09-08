package com.qs.libs.toolautoconfigure.threadpool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 线程池参数配置类
 *
 * @author qiansheng
 * @date 2021/9/7 下午3:44
 */
@ConfigurationProperties(prefix = "thread.config")
@Component
public class ThreadPoolProperties {

    /**
     * 每秒需要多少个线程处理?
     * tasks/(1/taskcost)
     */
    private int corePoolSize = 20;

    /**
     * 线程池维护线程的最大数量
     * (max(tasks)- queueCapacity)/(1/taskcost)
     */
    private int maxPoolSize = 100;

    /**
     * 缓存队列
     * (coreSizePool/taskcost)*responsetime
     */
    private int queueCapacity = 50;

    /**
     * 允许的空闲时间
     * 默认为60
     */
    private int keepAlive = 100;

    /**
     * 线程池名称前缀
     */
    private String threadNamePrefix;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive) {
        this.keepAlive = keepAlive;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }
}
