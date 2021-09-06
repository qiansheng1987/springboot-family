package com.qs.libs.qstool.samples.controller;

import com.qs.libs.qstoolcore.logging.annotation.OperationLogAnnotation;
import com.qs.libs.qstoolcore.logging.enums.OperationTypeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @GetMapping("/v1/mvc")
    @OperationLogAnnotation(type = OperationTypeEnum.SELECT, prefix = "用户ID")
    public Boolean testInterceptor(){
        return true;
    }
}
