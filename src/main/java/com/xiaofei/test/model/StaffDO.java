package com.xiaofei.test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffDO {

    private String staffId;

    private String staffName;

    private String staffCode;

    private String sex;

    private String password;

    private String stat;

    private String verifycode;
}
