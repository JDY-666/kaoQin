package com.jc.controller;

import com.jc.entity.CheckReport;
import com.jc.service.CheckReportService;
import com.jc.util.ResultMap;
import com.jc.util.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/report")
public class CheckReportController {
    @Autowired
    private CheckReportService service;
    @ResponseBody
    @RequestMapping("/list")
    public ResultMap list(Integer page,Integer limit,String username,String startDay,String endDay){
        if (startDay == null || startDay == ""){
            startDay = Today.getFirstDay();
        }
        if (endDay == null|| endDay == ""){
            endDay = Today.getLastDay();
        }
        return ResultMap.ok(service.list(page,limit,username,startDay,endDay),service.count(username));
    }

    @RequestMapping("/detail")
    public String detail(Integer reportId, Model model){
        CheckReport detail = service.detail(reportId);
        model.addAttribute("reportDetail",detail);
        return "/report_detail";
    }
}
