package com.qs.libs.qstoolcommon.enums.base;

import java.io.Serializable;

/**
 * 聚合对象基类
 *
 * @author qiansheng
 * @date 2021/8/30 下午7:16
 */
public interface Aggregate<T> extends Serializable {

    /**
     *
     * 通过聚合根唯一标识判断是否为同一聚合对象
     *
     * @param other other Aggregate
     * @return boolean
     */
    boolean isSameAggregate(T other);
}
