package com.qs.libs.qstoolcommon.enums.base;

import java.io.Serializable;

/**
 * 值对象基类
 *
 * @author qiansheng
 * @date 2021/8/30 下午7:14
 */
public interface ValueObject<T> extends Serializable {

    /**
     * 根据属性值判断是否为同一对象
     *
     * @param other other ValueObject
     * @return boolean
     */
    boolean isSameValue(T other);
}
