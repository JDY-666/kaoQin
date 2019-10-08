package com.jc.dao;

import com.jc.entity.Station;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StationMapper {
    List<Station> listStation(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username);
    List<Station> listStaName();
    Integer addStation(Station station);
    Integer count();
    Station findById(Integer staId);
    Integer updateStation(Station station);
    Integer delete(@Param("list")List<Integer> list);
}
