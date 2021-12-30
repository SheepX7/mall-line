package com.line.mall.admin.service;

import com.line.mall.common.api.CommonResult;

public interface LineAdminService {
    CommonResult login(String username, String password);
}
