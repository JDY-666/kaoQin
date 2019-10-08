package com.jc.controller;

import com.alibaba.fastjson.JSON;
import com.jc.entity.Classes;
import com.jc.service.ClassesService;
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
@RequestMapping("/cl")
public class ClassesController {
    @Autowired
    private ClassesService service;
    @RequestMapping("/list")
    @ResponseBody
    public ResultMap list(Integer page,Integer limit,String username){
        return ResultMap.ok(service.list(page, limit, username),service.count());
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResultMap add(Classes classes){
        System.out.println(classes.getClMorning());
        Integer i = service.add(classes);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(Classes classes){
        Integer i = service.update(classes);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap deleteStation(String data,Integer clId2){

        List<Integer> clId = new ArrayList<>();
        if (clId2 == null){
            List<Map> list = JSON.parseArray(data,Map.class);
            for (Map map : list) {
                clId.add((Integer) map.get("clId"));
            }
        }else {
            clId.add(clId2);
        }
        Integer i = service.delete(clId);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/type")
    public String pd(String type, Model model, Integer clId){

        model.addAttribute("type","add");
        model.addAttribute("classes",new Classes());
        if ("edit".equals(type)){
            model.addAttribute("type","edit");
            model.addAttribute("classes",service.finById(clId));
        }
        return "/cl_save";
    }
}
