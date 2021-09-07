package com.qs.libs.qstoolcommon.enums.base;

/**
 * 抽象规格
 *
 * @author qiansheng
 * @date 2021/8/24 下午2:22
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

    @Override
    public abstract boolean isSatisfiedBy(T t);

}
