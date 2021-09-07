package com.qs.libs.qstoolcommon.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统业务代码定义枚举
 *
 * @author qiansheng
 */
@Getter
@AllArgsConstructor
public enum BizCodeEnum implements ICommonEnum<Integer, String> {

    /*成功*/
    SUCCESS(200, "成功！"),

    /*系统级异常code定义 1000~1999 begin*/
    SYSTEM_UNKNOWN_ERROR(1001, "系统未知异常，请联系管理员！"),
    SERVICE_ERROR(1001, "服务异常！"),
    SERVICE_NOT_AVAILABLE(1002, "当前服务暂不可用！"),
    SERVICE_UPGRADING(1003, "服务升级中！"),
    /*系统级别code定义 1000~1999 end*/

    /*接口级异常code定义 begin*/
    ILLEGAL_ARGS_ERROR(2001, "参数不合法！"),
    BAD_REQUEST_ERROR(2002, "参数解析失败！"),
    HTTP_METHOD_NOT_ALLOWED(2003, "请求方法不合法！"),
    DB_EXCEPTION(2004, "数据入库异常！"),
    PERMISSION_DENIED(2005, "权限不足！"),
    BIZ_LOGIC_ERROR(2006, "业务逻辑异常！")
    /*接口级别code定义 end*/;

    private final Integer code;
    private final String message;


    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
