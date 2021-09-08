package com.qs.libs.qstool.samples.controller;

import com.qs.libs.qstool.samples.model.UserCmd;
import com.qs.libs.qstoolcore.logging.annotation.OperationLogAnnotation;
import com.qs.libs.qstoolcore.logging.enums.OperationTypeEnum;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @PostMapping("/v1/mvc")
    @OperationLogAnnotation(type = OperationTypeEnum.SELECT, prefix = "用户ID")
    public Object testInterceptor(@RequestBody UserCmd cmd){
        return cmd;
    }

    /**
     * 该接口在切面中，记录的日志内容为：
     * 用户名称:zhangsan,昵称:张三
     */
    @OperationLogAnnotation(type = OperationTypeEnum.INSERT,prefix = {"用户名称"}, field = {"name", "age"})
    @PostMapping("/v1/mvc/save")
    public Object save(@RequestBody UserCmd user) {
        return user;
    }
}
