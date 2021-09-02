package com.qs.libs.qstool.samples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @GetMapping("/v1/mvc")
    public Boolean testInterceptor(){
        return true;
    }
}
