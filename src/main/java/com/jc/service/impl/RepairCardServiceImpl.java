package com.jc.service.impl;

import com.jc.dao.RepairCardMapper;
import com.jc.entity.RepairCard;
import com.jc.service.RepairCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepairCardServiceImpl implements RepairCardService {
    @Autowired
    private RepairCardMapper mapper;
    @Override
    public List<RepairCard> list(Integer page, Integer limit, String username) {
        return mapper.list((page-1)*limit,limit,username);
    }

    @Override
    public Integer add(RepairCard repairCard) {
        return mapper.add(repairCard);
    }

    @Override
    public RepairCard findById(Integer repairId) {
        return mapper.findById(repairId);
    }

    @Override
    public Integer count(String username) {
        return mapper.count(username);
    }
}
