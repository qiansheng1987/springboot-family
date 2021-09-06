package com.qs.libs.qstoolcore.logging.model;

import com.qs.libs.qstoolcore.logging.enums.OperationTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * OperationLog
 *
 * @author qiansheng
 * @date 2021/9/6 下午3:13
 */
@Data
public class OperationLog {

    /**
     * 日志类型
     */
    private OperationTypeEnum logType;

    /**
     * 日志内容
     */
    private String contents;

    /**
     * 时间
     */
    private Date time;

    /**
     * 是否成功 1是 0否
     */
    private Integer success;

    /**
     * 错误原因
     */
    private String errorReason;
}
