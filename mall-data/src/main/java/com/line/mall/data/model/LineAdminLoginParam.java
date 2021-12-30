package com.line.mall.data.model;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class LineAdminLoginParam {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
