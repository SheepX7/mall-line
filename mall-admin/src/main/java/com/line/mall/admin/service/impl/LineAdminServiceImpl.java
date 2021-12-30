package com.line.mall.admin.service.impl;

import com.line.mall.admin.service.AuthService;
import com.line.mall.admin.service.LineAdminService;
import com.line.mall.common.api.CommonResult;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LineAdminServiceImpl implements LineAdminService {

    @Autowired
    private AuthService authService;

    @Override
    public CommonResult login(String username, String password) {
        if (StringUtil.isNullOrEmpty(username) ||
                StringUtil.isNullOrEmpty(password)) {
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", "");
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        return authService.getAccessToken(params);
    }
}
