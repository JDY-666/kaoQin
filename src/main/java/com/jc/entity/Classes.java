package com.jc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;


@Getter
@Setter
public class Classes {
    private Integer clId;
    private String clNo;
    private String clName;
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private String clMorning;
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private String clEvening;
}
