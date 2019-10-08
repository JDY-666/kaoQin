package com.jc.controller;

import com.alibaba.fastjson.JSON;
import com.jc.entity.Account;
import com.jc.entity.Classes;
import com.jc.entity.Employee;
import com.jc.entity.Station;
import com.jc.service.*;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private StationService stationService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private DepartmentService departService;
    @ResponseBody
    @RequestMapping("/list")
    public ResultMap listEmployee(Integer page,Integer limit,String username){
        return ResultMap.ok(service.listEmployee((page-1)*limit,limit,username),service.count()-1);
    }
    @ResponseBody
    @RequestMapping("/update")
    public ResultMap updateEmployee(Employee employee){
        return ResultMap.ok(service.updateEmployee(employee));
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(String data,Integer empId2){

        List<Integer> empId = new ArrayList<>();
        if (empId2 == null){
            List<Map> list = JSON.parseArray(data,Map.class);
            for (Map map : list) {

                empId.add((Integer) map.get("empId"));
            }
        }else {

            empId.add(empId2);
        }
        Integer i = service.delete(empId);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResultMap addEmployee(Employee employee){
        System.out.println(employee.getEmpNo());
        Integer i = service.add(employee);
        if (i > 0){
            accountService.add(new Account(employee.getEmpNo(),"123456"));
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/type")
    public String pd(String type, Model model, Integer empId){

        List<Station> stations = stationService.listStaName();
        List<Classes>  classes = classesService.listClass();
        model.addAttribute("sta",stations);
        model.addAttribute("classes",classes);
        model.addAttribute("type","add");
        model.addAttribute("emp",new Employee());
        if ("edit".equals(type)){
            Employee employee = service.findById(empId,null);
            model.addAttribute("type","edit");
            model.addAttribute("emp",employee);
        }
        return "/employee_add";
    }
}
