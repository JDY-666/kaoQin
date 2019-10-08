package com.jc.controller;

import com.alibaba.fastjson.JSON;
import com.jc.entity.CheckReport;
import com.jc.entity.Classes;
import com.jc.entity.Employee;
import com.jc.entity.PaySalary;
import com.jc.service.CheckReportService;
import com.jc.service.ClassesService;
import com.jc.service.EmployeeService;
import com.jc.service.PaySalaryService;
import com.jc.util.ResultMap;
import com.jc.util.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PaySalaryController {
    @Autowired
    private PaySalaryService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CheckReportService reportService;
    @Autowired
    private ClassesService classesService;
    @ResponseBody
    @RequestMapping("/list")
    public ResultMap list(Integer page,Integer limit,String username){
        return ResultMap.ok(service.list(page,limit,username),service.count(username));
    }
    @ResponseBody
    @RequestMapping("/counts")
    public ResultMap counts(PaySalary paySalary){
        //获取薪水
        Employee employee = employeeService.findById(null, paySalary.getPayNo());
        Integer salary = employee.getEmpSalary();
        Classes classes = classesService.finById(employee.getClId());
        List<CheckReport> list = reportService.findByNo(paySalary.getPayNo());
        Integer hour = 0;
        if (list != null){
            for (CheckReport checkReport : list) {
                hour += Today.getHour(checkReport.getReportMorning(),checkReport.getReportEvening());
            }
        }
  //      System.out.println(classes.getClMorning());
 //       Integer hourCounts = Today.getHour(classes.getClMorning(),classes.getClEvening());
//        Integer pay = salary*hour/(Today.getWorkDays(paySalary.getPayStartDate(),paySalary.getPayEndDate())*9);
        Integer pay = salary*hour/(Today.getMonthInfo()*8);
        return ResultMap.ok(pay);
    }
    @ResponseBody
    @RequestMapping("/add")
    public ResultMap add(PaySalary paySalary){
        service.add(paySalary);
        return ResultMap.ok();
    }
    @ResponseBody
    @RequestMapping("/update")
    public ResultMap update(PaySalary paySalary){
        service.update(paySalary);
        return ResultMap.ok();
    }
    @ResponseBody
    @RequestMapping("/delete")
    public ResultMap delete(String data,Integer payId2){

        List<Integer> payId = new ArrayList<>();
        if (payId2 == null){
            List<Map> list = JSON.parseArray(data,Map.class);
            for (Map map : list) {
                payId.add((Integer) map.get("payId"));
            }
        }else {
            payId.add(payId2);
        }
        Integer i = service.delete(payId);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/type")
    public String pd(String type, Model model, String payNo){
        List<Employee> employees = employeeService.listAll();
        model.addAttribute("employees",employees);
        model.addAttribute("type","add");
        if ("edit".equals(type)){
            model.addAttribute("type","edit");
            model.addAttribute("pay",service.findByNo(payNo));
        }

        return "/pay_save";
    }
}
