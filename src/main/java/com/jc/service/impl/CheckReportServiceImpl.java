package com.jc.service.impl;

import com.jc.dao.CheckReportMapper;
import com.jc.entity.CheckReport;
import com.jc.service.CheckReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckReportServiceImpl implements CheckReportService {
    @Autowired
    private CheckReportMapper mapper;
    @Override
    public Integer add(CheckReport checkReport) {
        return mapper.add(checkReport);
    }

    @Override
    public Integer update(CheckReport checkReport) {
        return mapper.update(checkReport);
    }

    @Override
    public CheckReport findByDate(String date) {
        return mapper.findByDate(date);
    }

    @Override
    public List<CheckReport> list(Integer page, Integer limit, String username,String startDay,String endDay) {
        return mapper.list((page-1)*limit,limit,username,startDay,endDay);
    }

    @Override
    public Integer count(String username) {
        return mapper.count(username);
    }

    @Override
    public CheckReport detail(Integer reportId) {
        return mapper.detail(reportId);
    }

    @Override
    public List<CheckReport> findByNo(String reportNo) {
        return mapper.findByNo(reportNo);
    }
}
