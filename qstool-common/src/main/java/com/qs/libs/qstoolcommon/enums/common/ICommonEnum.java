package com.qs.libs.qstoolcommon.enums.common;

/**
 * 枚举通用接口
 *
 * @author qiansheng
 * @date 2021/8/6 下午6:12
 */
public interface ICommonEnum<C, M> {

    /**
     * 状态码
     * @return C
     */
    C code();

    /**
     * 描述信息
     * @return M
     */
    M message();

}
