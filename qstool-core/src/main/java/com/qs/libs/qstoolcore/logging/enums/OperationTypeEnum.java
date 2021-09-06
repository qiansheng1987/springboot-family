package com.qs.libs.qstoolcore.logging.enums;

import lombok.Getter;

/**
 * 操作类型枚举
 *
 * @author qiansheng
 * @date 2021/9/6 下午3:10
 */
@Getter
public enum OperationTypeEnum {

    /**
     * 查询
     */
    SELECT(10, "查询"),

    /**
     * 插入，新增
     */
    INSERT(11, "新增"),

    /**
     * 更新
     */
    UPDATE(12, "更新"),

    /**
     * 删除
     */
    DELETE(13, "删除"),

    /**
     * 下载
     */
    DOWNLOAD(20, "下载"),

    /**
     * 上传
     */
    UPLOAD(21, "上传");


    private Integer type;
    private String message;

    OperationTypeEnum(Integer type, String message) {
        this.type = type;
        this.message = message;
    }
}
