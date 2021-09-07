package com.qs.libs.qstoolcommon.enums.base;

/**
 * 具有并关系的规格
 *
 * @author qiansheng
 * @date 2021/8/25 上午10:00
 */
public class AndSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> specificationA;

    private Specification<T> specificationB;

    public AndSpecification(Specification<T> specificationA, Specification<T> specificationB) {
        this.specificationA = specificationA;
        this.specificationB = specificationB;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return specificationA.isSatisfiedBy(t) & specificationB.isSatisfiedBy(t);
    }
}
