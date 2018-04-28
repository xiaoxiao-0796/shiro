package com.xiaofei.test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class RoleDO {

    private String roleId;

    private String roleName;

    private String roleLayer;

    private String roleSeq;

    private String roleDesc;

    private String stat;
}
