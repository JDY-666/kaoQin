package com.jc.controller;

import com.alibaba.fastjson.JSON;
import com.jc.entity.Department;
import com.jc.service.DepartmentService;
import com.jc.service.EmployeeService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dep")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/list")
    @ResponseBody
    public ResultMap listDep(Integer page, Integer limit, String username) {
        return ResultMap.ok(service.listDep(page,limit,username),service.count()-1);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(String data,Integer depId2){

        List<Integer> depId = new ArrayList<>();
        if (depId2 == null){
            List<Map> list = JSON.parseArray(data,Map.class);
            for (Map map : list) {
                depId.add((Integer) map.get("depId"));
            }
        }else {
            depId.add(depId2);
        }
        Integer i = service.delete(depId);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/type")
    public String pd(String type, Model model,Integer depId){
        List<String> list = employeeService.listEmName();
        model.addAttribute("empName",list);
        model.addAttribute("type","add");
        model.addAttribute("dep",new Department());
        if ("edit".equals(type)){
            model.addAttribute("type","edit");
            model.addAttribute("dep",service.findById(depId));
        }
        return "/department_add";
    }
    @PostMapping("/add")
    @ResponseBody
    public ResultMap addDep(Department department){
        Integer i = service.addDep(department);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @PostMapping("/update")
    @ResponseBody
    public ResultMap updateDep(Department department){
        Integer i = service.updateDep(department);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
}
