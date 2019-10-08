package com.jc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;



@Getter
@Setter
public class PunchCard {
    private Integer punchId;
    private String punchNo;
    private String punchName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String punchDate;
    private String punchText;
}
