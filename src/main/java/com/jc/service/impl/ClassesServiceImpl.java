package com.jc.service.impl;

import com.jc.dao.ClassesMapper;
import com.jc.entity.Classes;
import com.jc.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper mapper;
    @Override
    public List<Classes> list(Integer page, Integer limit, String username) {
        return mapper.list((page-1)*limit,limit,username);
    }

    @Override
    public Integer count() {
        return mapper.count();
    }

    @Override
    public Classes finById(Integer clId) {
        return mapper.finById(clId);
    }

    @Override
    public Integer add(Classes classes) {
        return mapper.add(classes);
    }

    @Override
    public Integer update(Classes classes) {
        return mapper.update(classes);
    }

    @Override
    public Integer delete(List<Integer> list) {
        return mapper.delete(list);
    }

    @Override
    public List<Classes> listClass() {
        return mapper.listClass();
    }
}
