package com.qs.libs.qstoolcommon.enums.common;


import cn.hutool.core.util.StrUtil;
import lombok.Getter;

/**
 * <p>业务异常对象</p>
 *
 * @author qiansheng
 */
@Getter
public class BusinessException extends RuntimeException {


    private static final long serialVersionUID = 883783270160325557L;

    private Integer code;

    /**
     * 构建业务异常
     *
     * @param commonEnum 业务码枚举
     */
    public BusinessException(ICommonEnum<Integer, String> commonEnum) {
        this(commonEnum.code(),commonEnum.message());
    }

    /**
     * 构建业务异常
     *
     * @param commonEnum 业务码枚举
     * @param params     异常信息
     */
    public BusinessException(ICommonEnum<Integer, String> commonEnum, Object... params) {
        this(commonEnum.code(), StrUtil.format(commonEnum.message(), params));
    }

    /**
     * 构建业务异常
     *
     * @param code    异常代码
     * @param message 异常信息
     */
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构建业务异常
     *
     * @param message 异常信息
     */
    public BusinessException(String message) {
        super(message);
    }

}
