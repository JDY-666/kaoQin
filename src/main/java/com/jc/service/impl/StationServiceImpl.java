package com.jc.service.impl;

import com.jc.dao.StationMapper;
import com.jc.entity.Station;
import com.jc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationMapper mapper;
    @Override
    public List<Station> listStation(Integer page, Integer limit, String username) {
        return mapper.listStation((page-1)*limit,limit,username);
    }

    @Override
    public List<Station> listStaName() {
        return mapper.listStaName();
    }

    @Override
    public Integer addStation(Station station) {
        return mapper.addStation(station);
    }

    @Override
    public Integer count() {
        return mapper.count();
    }

    @Override
    public Station findById(Integer staId) {
        return mapper.findById(staId);
    }

    @Override
    public Integer updateStation(Station station) {
        return mapper.updateStation(station);
    }

    @Override
    public Integer delete(List<Integer> list) {
        return mapper.delete(list);
    }
}
