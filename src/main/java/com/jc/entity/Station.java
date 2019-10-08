package com.jc.entity;

import com.jc.util.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Station {
    private Integer staId;
    private String staNo;
    private String staName;
    private Integer depId;
    private String staSuperior;
    private Gender staCategory;
    private String staDesc;
    private Department department;
}
