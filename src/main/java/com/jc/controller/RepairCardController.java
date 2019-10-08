package com.jc.controller;

import com.jc.entity.*;
import com.jc.service.CheckReportService;
import com.jc.service.ClassesService;
import com.jc.service.EmployeeService;
import com.jc.service.RepairCardService;
import com.jc.util.ResultMap;
import com.jc.util.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/repair")
public class RepairCardController {
    @Autowired
    private RepairCardService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CheckReportService reportService;
    @Autowired
    private ClassesService classesService;
    @RequestMapping("/list")
    @ResponseBody
    public ResultMap list(Integer page, Integer limit, String username){
        return ResultMap.ok(service.list(page,limit,username),service.count(username));
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResultMap add(RepairCard repairCard){
        String repairNo = repairCard.getRepairNo();
        String repairDate = repairCard.getRepairDate();
        //查询班次
        Integer clId = employeeService.findById(null, repairNo).getClId();
        Classes classes = classesService.finById(clId);
        //查询当天是否有签到
        CheckReport date = reportService.findByDate(repairDate.substring(0,10));
        if (date == null){

        }else {
            CheckReport checkReport = new CheckReport();
            String status = date.getReportStatus();
            switch (status){
                case "迟到":
                    if (repairDate.substring(11).compareTo(classes.getClMorning())<0){
                        status = "正常";
                    }
                    checkReport.setReportMorning(repairDate);
                    break;
                case "早退":
                    if (repairDate.substring(11).compareTo(classes.getClEvening())>0){
                        status = "正常";
                    }
                    checkReport.setReportEvening(repairDate);
                    break;
                case "旷工":
//                    date.getReportMorning()
                    break;
            }
            checkReport.setReportStatus(status);
            checkReport.setReportId(date.getReportId());
            reportService.update(checkReport);
        }
        Integer i = service.add(repairCard);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/type")
    public String pd(String type, Model model, HttpServletRequest request, Integer repairId){
        Account account = (Account) request.getSession().getAttribute("userAccount");
        Employee employee = employeeService.findById(null, account.getUsername());
        model.addAttribute("employee",employee);
        model.addAttribute("type","add");
        if ("edit".equals(type)){
            model.addAttribute("type","edit");
         //   PunchCard punchCard = service.findById(punchId);
        //    employee.setEmpName(punchCard.getPunchName());
        //    model.addAttribute("punchCard",punchCard);
        //    model.addAttribute("employee",employee);
        }

        return "/repair_save";
    }
}
