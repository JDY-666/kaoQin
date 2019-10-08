package com.jc.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
    private Integer depId;
    private String depNo;
    private String depName;
    private String depLeader;
    private String depDuty;
    private String depHigher;
}
