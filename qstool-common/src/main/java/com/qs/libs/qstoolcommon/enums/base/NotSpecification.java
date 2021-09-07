package com.qs.libs.qstoolcommon.enums.base;

/**
 * 不满足规范
 *
 * @author qiansheng
 * @date 2021/8/25 上午10:07
 */
public class NotSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> spec;

    public NotSpecification(Specification<T> spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return !spec.isSatisfiedBy(t);
    }
}
