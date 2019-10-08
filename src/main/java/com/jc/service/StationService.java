package com.jc.service;

import com.jc.entity.Station;

import java.util.List;

public interface StationService {
    List<Station> listStation(Integer page,Integer limit,String username);
    List<Station> listStaName();
    Integer addStation(Station station);
    Integer count();
    Station findById(Integer staId);
    Integer updateStation(Station station);
    Integer delete(List<Integer> list);
}
