package com.jc.dao;

import com.jc.entity.CheckReport;
import com.jc.entity.Station;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckReportMapper {
    Integer add(CheckReport checkReport);
    Integer update(CheckReport checkReport);
    List<CheckReport> findByNo(String reportNo);
    CheckReport findByDate(@Param("date") String date);
    List<CheckReport> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username,@Param("startDay") String startDay,@Param("endDay")String endDay);
    Integer count(@Param("username")String username);
    CheckReport detail(Integer reportId);
}
