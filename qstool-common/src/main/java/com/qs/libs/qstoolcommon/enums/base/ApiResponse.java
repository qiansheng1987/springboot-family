package com.qs.libs.qstoolcommon.enums.base;

import com.qs.libs.qstoolcommon.enums.common.BizCodeEnum;
import com.qs.libs.qstoolcommon.enums.common.BusinessException;
import com.qs.libs.qstoolcommon.enums.common.ICommonEnum;
import lombok.Data;

/**
 * API返回值
 *
 * @author qiansheng
 * @date 2021/8/6 下午6:00
 */
@Data
public class ApiResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    private ApiResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>(BizCodeEnum.SUCCESS.getCode(),
                BizCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(BizCodeEnum.SUCCESS.getCode(),
                BizCodeEnum.SUCCESS.getMessage(), data);
    }

    public static  <T> ApiResponse<T> failure() {
        return new ApiResponse<T>(BizCodeEnum.SERVICE_ERROR.getCode(),
                BizCodeEnum.SERVICE_ERROR.getMessage(),null);
    }

    public static <T> ApiResponse<T> failure(T data, ICommonEnum<Integer, String> commonEnum) {
        return new ApiResponse<T>(commonEnum.code(), commonEnum.message(), data);
    }

    public static <T> ApiResponse<T> failure(ICommonEnum<Integer, String> commonEnum) {
        return new ApiResponse<T>(commonEnum.code(), commonEnum.message(), null);
    }

    public static ApiResponse<?> failure(BusinessException ex) {
        Integer code = ex.getCode();
        String message = ex.getMessage();
        return failure(code, message);
    }

    public static ApiResponse<?> failure(BizCodeEnum bizCodeEnum) {
        return failure(bizCodeEnum.getCode(), bizCodeEnum.getMessage());
    }

    public static ApiResponse<?> failure(String message) {
        return failure(BizCodeEnum.SYSTEM_UNKNOWN_ERROR.getCode(), message);
    }

    public static ApiResponse<?> failure(Integer code, String message) {
        return new ApiResponse<>(code, message, "");
    }


}
