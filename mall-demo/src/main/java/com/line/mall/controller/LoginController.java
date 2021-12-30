package com.line.mall.controller;

import com.line.mall.common.api.CommonResult;
import com.line.mall.data.model.LineAdmin;
import com.line.mall.data.repository.LineAdminRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LineAdminRepository lineAdminRepository;

    @RequestMapping(path = "/login")
    public CommonResult login() {
        return CommonResult.success(lineAdminRepository.findLineAdminById(1L));
    }
}
