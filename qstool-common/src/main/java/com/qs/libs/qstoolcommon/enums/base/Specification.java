package com.qs.libs.qstoolcommon.enums.base;

/**
 * 规格接口
 *
 * @author qiansheng
 * @date 2021/8/24 下午2:19
 */
public interface Specification<T> {

    /**
     * 检查对象t是否满足规范
     *
     * @param t T
     * @return true: 满足规范，false:不满足规范
     */
    boolean isSatisfiedBy(T t);

}
