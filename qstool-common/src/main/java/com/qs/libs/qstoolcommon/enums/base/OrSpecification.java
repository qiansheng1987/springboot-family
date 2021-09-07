package com.qs.libs.qstoolcommon.enums.base;

/**
 * 或关系的规格
 *
 * @author qiansheng
 * @date 2021/8/25 上午10:05
 */
public class OrSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> specificationA;

    private Specification<T> specificationB;

    public OrSpecification(Specification<T> specificationA, Specification<T> specificationB) {
        this.specificationA = specificationA;
        this.specificationB = specificationB;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return specificationA.isSatisfiedBy(t) || specificationB.isSatisfiedBy(t);
    }
}
