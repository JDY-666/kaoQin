package com.jc.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Integer empId;
    private String empNo;
    private String empName;
    private String empSex;
    private Integer empAge;
    private String empNation;
    private String empIdentity;
    private Integer empSalary;
    private String empPhone;
    private String emergencyName;
    private String emergencyPhone;
    private String empDesc;
    private String empSta;
    private Station station;
    private Integer clId;
    private Classes classes;
}
