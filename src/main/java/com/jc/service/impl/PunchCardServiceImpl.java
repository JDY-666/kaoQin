package com.jc.service.impl;

import com.jc.dao.PunchCardMapper;
import com.jc.entity.PunchCard;
import com.jc.service.PunchCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PunchCardServiceImpl implements PunchCardService {
    @Autowired
    private PunchCardMapper mapper;
    @Override
    public List<PunchCard> list(Integer page, Integer limit, String username) {
        return mapper.list((page-1)*limit,limit,username);
    }

    @Override
    public Integer add(PunchCard punchCard) {
        return mapper.add(punchCard);
    }

    @Override
    public PunchCard findById(Integer punchId) {
        return mapper.findById(punchId);
    }

    @Override
    public Integer count() {
        return mapper.count();
    }
}
