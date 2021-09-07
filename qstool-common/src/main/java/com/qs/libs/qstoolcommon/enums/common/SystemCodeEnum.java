package com.qs.libs.qstoolcommon.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统代码枚举
 *
 * @author qiansheng
 * @date 2021/8/9 11:12
 */
@Getter
@AllArgsConstructor
public enum SystemCodeEnum implements ICommonEnum<Integer, String>{

    /**
     * 成功
     */
    SUCCESS(200, "成功！"),
    SYSTEM_UNKNOWN_ERROR(10, "系统未知异常，请联系管理员！"),
    SERVICE_ERROR(11, "服务异常！"),
    SERVICE_NOT_AVAILABLE(12, "当前服务暂不可用！"),
    SERVICE_UPGRADING(13, "服务升级中！"),
    PERMISSION_QUERY_DENIED(14, "没有数据查询权限！"),
    BIZ_LOGIC_ERROR(2000, "业务逻辑异常！");


    private Integer code;
    private String message;

    @Override
    public Integer code() {
        return this.getCode();
    }

    @Override
    public String message() {
        return this.getMessage();
    }
}
