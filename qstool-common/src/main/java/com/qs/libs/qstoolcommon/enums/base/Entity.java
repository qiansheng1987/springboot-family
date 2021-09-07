package com.qs.libs.qstoolcommon.enums.base;

import java.io.Serializable;

/**
 * 实体基类
 *
 * @author qiansheng
 * @date 2021/8/30 下午7:11
 */
public interface Entity<T> extends Serializable {

    /**
     * 通过比较实体唯一标识符判断是否为同一个实体
     *
     * @param other other Entity
     * @return boolean
     */
    boolean isSameEntity(T other);
}
