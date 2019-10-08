package com.jc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckReport {
    private Integer reportId;
    private String reportNo;
    private String reportName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String reportMorning;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String reportEvening;
    private String reportStatus;

    public CheckReport(String reportNo, String reportName, String reportMorning, String reportEvening, String reportStatus) {
        this.reportNo = reportNo;
        this.reportName = reportName;
        this.reportMorning = reportMorning;
        this.reportEvening = reportEvening;
        this.reportStatus = reportStatus;
    }

    public CheckReport(Integer reportId, String reportEvening, String reportStatus) {
        this.reportId = reportId;
        this.reportEvening = reportEvening;
        this.reportStatus = reportStatus;
    }
}
