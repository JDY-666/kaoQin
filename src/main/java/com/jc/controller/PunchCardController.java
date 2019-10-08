package com.jc.controller;

import com.jc.entity.*;
import com.jc.service.CheckReportService;
import com.jc.service.ClassesService;
import com.jc.service.EmployeeService;
import com.jc.service.PunchCardService;
import com.jc.util.ResultMap;
import com.jc.util.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/punch")
public class PunchCardController {
    @Autowired
    private PunchCardService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private CheckReportService reportService;
    @RequestMapping("/list")
    @ResponseBody
    public ResultMap list(Integer page,Integer limit,String username){
        return ResultMap.ok(service.list(page,limit,username),service.count());
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResultMap add(PunchCard punchCard){

        String punchNo = punchCard.getPunchNo();
        String punchName = punchCard.getPunchName();
        String punchDate = punchCard.getPunchDate();
        //查询班次
        Integer clId = employeeService.findById(null, punchNo).getClId();
        Classes classes = classesService.finById(clId);
        //查询当天是否有签到
        CheckReport date = reportService.findByDate(Today.getDay());
        String status = "旷工";

        if (punchDate.compareTo(Today.times(12,0))<0){
            reportService.add(new CheckReport(punchNo,punchName,punchDate,null,status));
        }else {
            if (date == null){
                reportService.add(new CheckReport(punchNo,punchName,null,punchDate,status));
            }else {
                status = "正常";
                if (date.getReportMorning().compareTo(classes.getClMorning())>0){
                    status = "迟到";
                }
                if (punchDate.compareTo(classes.getClEvening())<0){
                    status = "早退";
                }
                reportService.update(new CheckReport(date.getReportId(),punchDate,status));
            }
        }

//        reportService.add(new CheckReport(punchNo,punchName,punchDate,));
        Integer i = service.add(punchCard);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/type")
    public String pd(String type, Model model, HttpServletRequest request,Integer punchId){
        Account account = (Account) request.getSession().getAttribute("userAccount");
        Employee employee = employeeService.findById(null, account.getUsername());
        model.addAttribute("employee",employee);
        model.addAttribute("type","add");
        if ("edit".equals(type)){
            model.addAttribute("type","edit");
            PunchCard punchCard = service.findById(punchId);
            employee.setEmpName(punchCard.getPunchName());
            model.addAttribute("punchCard",punchCard);
            model.addAttribute("employee",employee);
        }

        return "/punch_save";
    }
}
