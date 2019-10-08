package com.jc.service;

import com.jc.entity.CheckReport;

import java.util.List;

public interface CheckReportService {
    Integer add(CheckReport checkReport);
    Integer update(CheckReport checkReport);
    CheckReport findByDate(String date);
    List<CheckReport> list(Integer page,Integer limit,String username,String startDay,String endDay);
    Integer count(String username);
    CheckReport detail(Integer reportId);
    List<CheckReport> findByNo(String reportNo);
}
