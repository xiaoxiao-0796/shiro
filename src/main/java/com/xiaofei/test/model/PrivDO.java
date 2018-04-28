package com.xiaofei.test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PrivDO {

    private String privId;

    private String privName;

    private String privType;

    private String parentPriv;

    private String showSeq;

    private String privUrl;

    private String operMode;

    private String pricDesc;

    private String stat;

    private String privImg;
}
