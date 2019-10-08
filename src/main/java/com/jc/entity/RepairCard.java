package com.jc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Getter
@Setter
public class RepairCard {
    private Integer repairId;
    private String repairNo;
    private String repairName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String repairDate;
    private String repairReason;
}
