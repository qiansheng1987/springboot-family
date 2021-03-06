package com.qs.libs.qstoolcore.logging.annotation;

import com.qs.libs.qstoolcore.logging.enums.OperationTypeEnum;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @author qiansheng
 * @date 2021/9/6 下午3:14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OperationLogAnnotation {

    /**
     * 是否需要记录日志，默认需要
     * @return boolean
     */
    boolean need() default true;

    /**
     * 日志类型
     * @return 日志类型
     */
    OperationTypeEnum type();

    /**
     * 记录日志时，拼接的前缀(默认后面加":")，当记录多个参数的字段时，前缀一般需要和字段（field）一一对应，
     * 当字段（field）数量大于前缀数量时，默认取最后一个前缀，作为超出的字段的记录前缀。
     */
    String[] prefix() default {};

    /**
     * 日志中记录的方法参数索引，默认记录第0个参数。如果字段（field）为空数组，则记录该参数所有信息。<br>
     * 如果该参数是集合（Collection），则遍历记录每一个元素。
     * @return 方法参数索引
     */
    int argsIndex() default 0;

    /**
     * 方法参数中需要记录的属性字段名，可设置多个需要记录日志的字段
     */
    String[] field() default {};
}
