package com.qs.libs.toolautoconfigure.logging;

import com.qs.libs.qstoolcore.logging.aspect.OperationLogAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 操作日志配置类
 *
 * @author qiansheng
 * @date 2021/9/6 下午3:38
 */
@Configuration
public class OperationLogConfiguration {

    @Bean
    public OperationLogAop operationLogAop() {
        return new OperationLogAop();
    }
}
