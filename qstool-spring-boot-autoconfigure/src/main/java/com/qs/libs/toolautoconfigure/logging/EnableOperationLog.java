package com.qs.libs.toolautoconfigure.logging;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启操作日志记录注解
 *
 * @author qiansheng
 * @date 2021/9/6 下午3:40
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({OperationLogConfiguration.class})
public @interface EnableOperationLog {
}
