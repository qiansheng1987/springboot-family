package com.qs.libs.qstoolcore.excel;

import lombok.Data;

import java.util.List;

/**
 * ExcelImportResult
 *
 * @author qiansheng
 * @date 2021/9/6 下午7:05
 */
@Data
public class ExcelImportResult {
    private List<String> messageList;
    private String excelFilePath;
}
