package com.line.mall.admin.controller;

import com.line.mall.admin.service.LineAdminService;
import com.line.mall.common.api.CommonResult;
import com.line.mall.data.model.LineAdminLoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class LineAdminController {

    @Autowired
    private LineAdminService adminService;

    @RequestMapping(path = "/logiin")
    public CommonResult login(@Validated @RequestBody LineAdminLoginParam lineAdminParam) {
        return adminService.login(lineAdminParam.getUsername(), lineAdminParam.getPassword());
    }
}
