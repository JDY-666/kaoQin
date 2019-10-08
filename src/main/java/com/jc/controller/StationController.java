package com.jc.controller;

import com.alibaba.fastjson.JSON;
import com.jc.entity.Department;
import com.jc.entity.Station;
import com.jc.service.DepartmentService;
import com.jc.service.StationService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sta")
public class StationController {
    @Autowired
    private StationService service;
    @Autowired
    private DepartmentService depService;
    @ResponseBody
    @RequestMapping("/list")
    public ResultMap listStation(Integer page,Integer limit,String username){
        return ResultMap.ok(service.listStation(page,limit,username),service.count());
    }
    @PostMapping("/add")
    @ResponseBody
    public ResultMap addStation(Station station){
        Integer i = service.addStation(station);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/update")
    @ResponseBody
    public ResultMap updateStation(Station station){
        Integer i = service.updateStation(station);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap deleteStation(String data,Integer staId2){

        List<Integer> staId = new ArrayList<>();
        if (staId2 == null){
            List<Map> list = JSON.parseArray(data,Map.class);
            for (Map map : list) {
                staId.add((Integer) map.get("staId"));
            }
        }else {
            staId.add(staId2);
        }
        Integer i = service.delete(staId);
        if (i > 0){
            return ResultMap.ok();
        }
        return ResultMap.fail(1);
    }
    @RequestMapping("/type")
    public String pd(String type, Model model, Integer staId){
        List<Department> list = depService.listDepName();
        List<Station> stations = service.listStaName();
        model.addAttribute("dep",list);
        model.addAttribute("sta",stations);
        model.addAttribute("type","add");
        model.addAttribute("station",new Station());
        if ("edit".equals(type)){
            model.addAttribute("type","edit");
            model.addAttribute("station",service.findById(staId));
        }
        return "/station_save";
    }
}
