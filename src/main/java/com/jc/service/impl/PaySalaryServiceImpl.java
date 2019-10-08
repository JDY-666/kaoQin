package com.jc.service.impl;

import com.jc.dao.PaySalaryMapper;
import com.jc.entity.PaySalary;
import com.jc.service.PaySalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaySalaryServiceImpl implements PaySalaryService {
    @Autowired
    private PaySalaryMapper mapper;
    @Override
    public List<PaySalary> list(Integer page, Integer limit, String username) {
        return mapper.list((page-1)*limit,limit,username);
    }

    @Override
    public Integer count(String username) {
        return mapper.count(username);
    }

    @Override
    public Integer add(PaySalary paySalary) {
        return mapper.add(paySalary);
    }

    @Override
    public Integer update(PaySalary paySalary) {
        return mapper.update(paySalary);
    }

    @Override
    public Integer delete(List<Integer> list) {
        return mapper.delete(list);
    }

    @Override
    public PaySalary findByNo(String payNo) {
        return mapper.findByNo(payNo);
    }
}
